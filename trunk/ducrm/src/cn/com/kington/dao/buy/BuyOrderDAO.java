package cn.com.kington.dao.buy;

import cn.com.kington.bean.buy.BuyOrder;
import cn.com.kington.bean.buy.BuyOrderSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ���ϲɹ�����BuyOrderDAO�����ӿ�
 * @author ������
 *
 */
public interface BuyOrderDAO extends BaseDAO<BuyOrder, BuyOrderSO> {
	/**
	 * ����BuyOrderSO����ɾ���ɹ���ϸ
	 * @param so
	 */
	public void deleteList(BuyOrderSO so);
}
