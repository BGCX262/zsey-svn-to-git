package cn.com.kington.dao.finance;

import cn.com.kington.bean.finance.OrderBudget;
import cn.com.kington.bean.finance.OrderBudgetSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 订单预算OrderBudgetDAO操作接口
 * @author 杜永生
 *
 */
public interface OrderBudgetDAO extends BaseDAO<OrderBudget, OrderBudgetSO> {
	/**
	 * 更新预算值 
	 * @param code：订单编号
	 * @param id：明细id
	 */
	public void updateBudget(String code, Long id);
	
	public void delete(OrderBudgetSO so);

}
