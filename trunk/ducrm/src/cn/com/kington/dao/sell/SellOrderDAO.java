package cn.com.kington.dao.sell;

import cn.com.kington.bean.sell.SellOrder;
import cn.com.kington.bean.sell.SellOrderSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 项目订单操作接口
 * 
 * @author 杜永生
 * 
 */
public interface SellOrderDAO extends BaseDAO<SellOrder, SellOrderSO> {
	/**
	 * 删除明细
	 * 
	 * @param id
	 *            ：订单ID
	 */
	public void deleteDetails(Long id);

}
