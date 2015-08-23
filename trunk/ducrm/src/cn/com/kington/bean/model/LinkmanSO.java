package cn.com.kington.bean.model;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.common.PublicType.ManSort;
import cn.com.kington.common.SOSupport;

/**
 * ��ϵ��
 * 
 * @author ������
 * 
 */
public class LinkmanSO extends SOSupport {
	private static final long serialVersionUID = -8762121471780654037L;
	private ManSort sort;// ��ϵ�˷���
	private Long dataId;// ��¼ID
	private Category relation;// ��ϵ
	private String name;// ����
	private String phone;// �绰
	private String mobile;// �ֻ�
	private String qq;// QQ
	private String email;// ����
	private String company;// ������λ����
	private String duty;// ְ��

	public LinkmanSO() {
		super();
	}

	public ManSort getSort() {
		return sort;
	}

	public void setSort(ManSort sort) {
		this.sort = sort;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public Category getRelation() {
		return relation;
	}

	public void setRelation(Category relation) {
		this.relation = relation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
}
