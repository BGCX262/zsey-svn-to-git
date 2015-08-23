package cn.com.kington.dao.basic;

import cn.com.kington.bean.model.Employee;
import cn.com.kington.bean.model.EmployeeSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 员工EmployeeDAO操作接口
 * @author 杜永生
 *
 */
public interface EmployeeDAO extends BaseDAO<Employee, EmployeeSO> {
	/**
	 * 检测员工编号是否存在
	 * @param employee
	 * @return true:已存在，false不存在
	 */
	public boolean checkCode(EmployeeSO so);

}
