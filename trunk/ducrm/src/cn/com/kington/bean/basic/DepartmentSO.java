package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * ����
 * 
 * @author ������
 * 
 */
public class DepartmentSO extends SOSupport {
	private static final long serialVersionUID = 2070515899459131558L;
	private String code;// ���
	private String name;// ����
	private Department department;// ��������
	private Long managerId;// ����Ա�����
	private String manager;// ���ž���
	private String phone;// ���ŵ绰
	private String fax;// ���Ŵ���

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
