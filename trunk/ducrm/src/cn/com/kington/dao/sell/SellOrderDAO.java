package cn.com.kington.dao.sell;

import cn.com.kington.bean.sell.SellOrder;
import cn.com.kington.bean.sell.SellOrderSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ��Ŀ���������ӿ�
 * 
 * @author ������
 * 
 */
public interface SellOrderDAO extends BaseDAO<SellOrder, SellOrderSO> {
	/**
	 * ɾ����ϸ
	 * 
	 * @param id
	 *            ������ID
	 */
	public void deleteDetails(Long id);

}
