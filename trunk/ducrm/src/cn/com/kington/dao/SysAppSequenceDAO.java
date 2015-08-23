package cn.com.kington.dao;

import cn.com.kington.bean.system.SysAppSequence;
import cn.com.kington.bean.system.SysAppSequenceSO;

/**
 * 流水号DAO操作接口
 * @author 杜永生
 *
 */
public interface SysAppSequenceDAO extends BaseDAO<SysAppSequence, SysAppSequenceSO> {
	/**
	 * 获取没前缀的流水号
	 * @param enname
	 * @param digit
	 * @return
	 */
	public String getNotPrefixSeqVal(String enname, int digit, String caption);
	
	/**
	 * 获取有前缀的流水号
	 * @param enname
	 * @param digit
	 * @return
	 */
	public String getPrefixSeqVal(String enname, int digit, String caption);
	
	/**
	 * 获取前缀为年份的流水号
	 * @param enname
	 * @param digit
	 * @return
	 */
	public String getYearSeqVal(String enname, int digit, String caption);
}
