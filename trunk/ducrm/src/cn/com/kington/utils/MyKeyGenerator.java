package cn.com.kington.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.type.Type;

/**
 * hibernate ID策略生成器
 * 规则: 年月 + 六位自增长序列
 * 例如：201201000001
 * @author 杜永生
 *
 */
public class MyKeyGenerator implements IdentifierGenerator, Configurable {
	private String table;
	private Connection connection;

	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		connection=session.connection();
		Long id=getSequenceValue(connection);
        return id;
	}

	public void configure(Type type, Properties params, Dialect dialect)
			throws MappingException {
		//取出table参数
		table = params.getProperty("table");
        if (table == null) {
            table = params.getProperty(PersistentIdentifierGenerator.TABLE);
        }
	}
	
	/**
	 * 获取流水号
	 * @param conn
	 * @return
	 */
	private long getSequenceValue(Connection conn){
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		long seqval=1;
		
		Date date=new Date();
		String seqdate=DateTools.formatDate(date, "yyyyMM");
		String now=DateTools.formatDate(date, "yyyy-MM-dd HH:mm:ss");
		String seqname=(seqdate+"_"+table).toUpperCase();
		
		
		try {
			conn.setAutoCommit(false);
			
			String sql="select seqValue+1 seqValue from sys_app_sequence where enSeqName=?";
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, seqname);
			rs=pstmt.executeQuery();
			if(rs.next()){
				seqval=rs.getLong("seqValue");
				sql="update sys_app_sequence set updateTime=?,seqValue=? where enSeqName=?";
				pstmt=conn.prepareStatement(sql);
				int index=0;
				pstmt.setString(++index, now);
				pstmt.setString(++index, seqval+"");
				pstmt.setString(++index, seqname);
				pstmt.executeUpdate();
			}else{
				seqval=1;
				sql="insert into sys_app_sequence (createTime,updateTime,flag,status,enSeqName,cnSeqName,seqValue) values (?,?,?,?,?,?,?)";
				
				int index=0;
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(++index, now);
				pstmt.setString(++index, now);
				pstmt.setBoolean(++index, true);
				pstmt.setBoolean(++index, true);
				pstmt.setString(++index, seqname);
				pstmt.setString(++index, table.toUpperCase());
				pstmt.setString(++index, seqval+"");
				pstmt.executeUpdate();
			}
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return Long.parseLong(seqdate+(StringTools.fillZero(seqval+"", 6)));
	}


}
