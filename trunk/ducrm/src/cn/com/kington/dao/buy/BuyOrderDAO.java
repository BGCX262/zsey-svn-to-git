package cn.com.kington.dao.buy;

import cn.com.kington.bean.buy.BuyOrder;
import cn.com.kington.bean.buy.BuyOrderSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 物料采购订单BuyOrderDAO操作接口
 * @author 杜永生
 *
 */
public interface BuyOrderDAO extends BaseDAO<BuyOrder, BuyOrderSO> {
	/**
	 * 根据BuyOrderSO对象删除采购明细
	 * @param so
	 */
	public void deleteList(BuyOrderSO so);
}
