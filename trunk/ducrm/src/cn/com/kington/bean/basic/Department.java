package cn.com.kington.bean.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * ����
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_department")
public class Department extends EntitySupport {
	private static final long serialVersionUID = -4467553772555025237L;
	@Column(nullable = false, length = 10)
	private String code;// ���
	@Column(nullable = false, length = 20)
	private String name;// ����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_department_id")
	private Department department;// ��������
	private Long managerId;// ����Ա�����
	@Column(length = 10)
	private String manager;// ���ž���
	@Column(length = 20)
	private String phone;// ���ŵ绰
	@Column(length = 20)
	private String fax;// ���Ŵ���

	public Department() {
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
