package cn.com.kington.dao;

import cn.com.kington.bean.system.SysAppSequence;
import cn.com.kington.bean.system.SysAppSequenceSO;

/**
 * ��ˮ��DAO�����ӿ�
 * @author ������
 *
 */
public interface SysAppSequenceDAO extends BaseDAO<SysAppSequence, SysAppSequenceSO> {
	/**
	 * ��ȡûǰ׺����ˮ��
	 * @param enname
	 * @param digit
	 * @return
	 */
	public String getNotPrefixSeqVal(String enname, int digit, String caption);
	
	/**
	 * ��ȡ��ǰ׺����ˮ��
	 * @param enname
	 * @param digit
	 * @return
	 */
	public String getPrefixSeqVal(String enname, int digit, String caption);
	
	/**
	 * ��ȡǰ׺Ϊ��ݵ���ˮ��
	 * @param enname
	 * @param digit
	 * @return
	 */
	public String getYearSeqVal(String enname, int digit, String caption);
}
