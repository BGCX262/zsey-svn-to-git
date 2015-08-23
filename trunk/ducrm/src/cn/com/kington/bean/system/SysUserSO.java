package cn.com.kington.bean.system;

import cn.com.kington.bean.model.Employee;
import cn.com.kington.common.SOSupport;

/**
 * 系统用户查询对象
 * @author 杜永生
 *
 */
public class SysUserSO extends SOSupport {
	private static final long serialVersionUID = -3673820828876480772L;
	private String username;// 用户
	private String password;// 密码
	private Employee employee;// 所属员工

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
