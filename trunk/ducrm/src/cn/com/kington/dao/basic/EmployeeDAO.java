package cn.com.kington.dao.basic;

import cn.com.kington.bean.model.Employee;
import cn.com.kington.bean.model.EmployeeSO;
import cn.com.kington.dao.BaseDAO;

/**
 * Ա��EmployeeDAO�����ӿ�
 * @author ������
 *
 */
public interface EmployeeDAO extends BaseDAO<Employee, EmployeeSO> {
	/**
	 * ���Ա������Ƿ����
	 * @param employee
	 * @return true:�Ѵ��ڣ�false������
	 */
	public boolean checkCode(EmployeeSO so);

}
