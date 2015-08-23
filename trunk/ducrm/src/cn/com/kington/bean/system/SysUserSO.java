package cn.com.kington.bean.system;

import cn.com.kington.bean.model.Employee;
import cn.com.kington.common.SOSupport;

/**
 * ϵͳ�û���ѯ����
 * @author ������
 *
 */
public class SysUserSO extends SOSupport {
	private static final long serialVersionUID = -3673820828876480772L;
	private String username;// �û�
	private String password;// ����
	private Employee employee;// ����Ա��

	public SysUserSO() {
		super();
	}

	public SysUserSO(String username, String password, Employee employee) {
		super();
		this.username = username;
		this.password = password;
		this.employee = employee;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
