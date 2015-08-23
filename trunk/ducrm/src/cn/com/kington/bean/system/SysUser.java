package cn.com.kington.bean.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.model.Employee;

@Entity
@Table(name = "sys_user")
public class SysUser extends EntitySupport {
	private static final long serialVersionUID = -7809320539896642173L;
	@Column(name = "username", nullable = false, unique = true)
	private String username;// 用户
	@Column(name = "password", nullable = false)
	private String password;// 密码
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_employee_id")
	private Employee employee;// 所属员工

	public SysUser() {
		super();
	}

	public SysUser(String username, String password, Employee employee) {
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
