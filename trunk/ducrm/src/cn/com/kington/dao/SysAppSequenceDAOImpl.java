package cn.com.kington.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.system.SysAppSequence;
import cn.com.kington.bean.system.SysAppSequenceSO;
import cn.com.kington.utils.DateTools;
import cn.com.kington.utils.StringTools;

public class SysAppSequenceDAOImpl extends BaseDAOImpl<SysAppSequence, SysAppSequenceSO> implements
		SysAppSequenceDAO {
	@Override
	public String getHqlWhere(SysAppSequenceSO so) {
		StringBuffer where=new StringBuffer();
		if(StringUtils.isNotEmpty(so.getEnSeqName())){
			where.append(" and enSeqName=:enSeqName");
		}
		
		if(StringUtils.isNotEmpty(so.getCnSeqName())){
			where.append(" and cnSeqName=:cnSeqName");
		}
		return where.toString();
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SysAppSequenceSO so) {
		if(StringUtils.isNotEmpty(so.getEnSeqName())){
			criteria.add(Restrictions.eq("enSeqName", StringUtils.trim(so.getEnSeqName())));
		}
		
		if(StringUtils.isNotEmpty(so.getCnSeqName())){
			criteria.add(Restrictions.ilike("cnSeqName", "%"+StringUtils.trim(so.getCnSeqName())+"%"));
		}
	}

	@Override
	public void setQueryParams(Query query, SysAppSequenceSO so) {
		if(StringUtils.isNotEmpty(so.getEnSeqName())){
			query.setParameter("enSeqName", StringUtils.trim(so.getEnSeqName()));
		}
		
		if(StringUtils.isNotEmpty(so.getCnSeqName())){
			query.setParameter("cnSeqName", "%"+StringUtils.trim(so.getCnSeqName())+"%");
		}
	}

	@Override
	public void switchVO2PO(SysAppSequence po, SysAppSequenceSO so) {
		if(StringUtils.isNotEmpty(so.getEnSeqName())){
			po.setEnSeqName(StringUtils.trim(so.getEnSeqName()));
		}
		
		if(StringUtils.isNotEmpty(so.getCnSeqName())){
			po.setCnSeqName(StringUtils.trim(so.getCnSeqName()));
		}
		
		if(StringUtils.isNotEmpty(so.getSeqValue())){
			po.setSeqValue(StringUtils.trim(so.getSeqValue()));
		}
	}
	
	public String getNotPrefixSeqVal(String enname, int digit, String caption){
		String val=getSequenceValue(enname);
		
		if(val.equals("1")){
			createSequence(enname, caption, val);
		}else{
			updateSequence(enname, val);
		}
		return StringTools.fillZero(val, digit);
	}
	
	public String getPrefixSeqVal(String enname, int digit, String caption){
		String date=DateTools.formatDate(new Date(), "yyyyMM");
		String seqname=(date+"_"+enname).toUpperCase();
		String val=getSequenceValue(seqname);
		
		if(val.equals("1")){
			createSequence(seqname, caption, val);
		}else{
			updateSequence(seqname, val);
		}
		return date+StringTools.fillZero(val, digit);
	}
	
	public String getYearSeqVal(String enname, int digit, String caption){
		String date=DateTools.formatDate(new Date(), "yyyy");
		String seqname=(date+"_"+enname).toUpperCase();
		String val=getSequenceValue(seqname);
		
		if(val.equals("1")){
			createSequence(seqname, caption, val);
		}else{
			updateSequence(seqname, val);
		}
		return date+StringTools.fillZero(val, digit);
	}
	
	/**
	 * 获取流水号值
	 * @param enname
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getSequenceValue(String enname) {
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createSQLQuery("select seqvalue+1 seqvalue from sys_app_sequence where enseqname=:enseqname");
		query.setParameter("enseqname", enname);
		List<Double> list=query.list();
		if(list!=null && list.size()>0){
			return list.get(0).longValue()+"";
		}
		return "1";
	}
	
	/**
	 * 创建新流水号
	 * @param enname
	 * @param cnname
	 * @param val
	 */
	public void createSequence(String enname, String cnname, String val) {
		String sql="insert into sys_app_sequence (createTime,updateTime,flag,status,enSeqName,cnSeqName,seqValue) " +
			"values (now(),now(),:flag,:status,:enSeqName,:cnSeqName,:seqValue)";
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createSQLQuery(sql);
		query.setParameter("flag", true);
		query.setParameter("status", true);
		query.setParameter("enSeqName", enname.toUpperCase());
		query.setParameter("cnSeqName", cnname.toUpperCase());
		query.setParameter("seqValue",val);
		query.executeUpdate();
		transaction.commit();
	}
	
	/**
	 * 更新流水号
	 * @param enname
	 * @param val
	 */
	public void updateSequence(String enname, String val) {
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createSQLQuery("update sys_app_sequence set updateTime=now(),seqValue=:seqValue where enSeqName=:enSeqName");
		query.setParameter("seqValue", val);
		query.setParameter("enSeqName", enname.toUpperCase());
		query.executeUpdate();
		transaction.commit();
	}

}
