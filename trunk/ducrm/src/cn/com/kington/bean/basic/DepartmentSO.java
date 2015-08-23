package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * 部门
 * 
 * @author 杜永生
 * 
 */
public class DepartmentSO extends SOSupport {
	private static final long serialVersionUID = 2070515899459131558L;
	private String code;// 编号
	private String name;// 名称
	private Department department;// 所属部门
	private Long managerId;// 所属员工编号
	private String manager;// 部门经理
	private String phone;// 部门电话
	private String fax;// 部门传真

	public DepartmentSO() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}
