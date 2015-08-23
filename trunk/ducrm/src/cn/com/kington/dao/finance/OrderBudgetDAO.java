package cn.com.kington.dao.finance;

import cn.com.kington.bean.finance.OrderBudget;
import cn.com.kington.bean.finance.OrderBudgetSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ����Ԥ��OrderBudgetDAO�����ӿ�
 * @author ������
 *
 */
public interface OrderBudgetDAO extends BaseDAO<OrderBudget, OrderBudgetSO> {
	/**
	 * ����Ԥ��ֵ 
	 * @param code���������
	 * @param id����ϸid
	 */
	public void updateBudget(String code, Long id);
	
	public void delete(OrderBudgetSO so);

}
