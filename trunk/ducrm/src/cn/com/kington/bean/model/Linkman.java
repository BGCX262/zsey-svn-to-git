package cn.com.kington.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.basic.Category;
import cn.com.kington.common.PublicType.ManSort;

/**
 * 联系人
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "base_linkman")
public class Linkman extends EntitySupport {
	private static final long serialVersionUID = -6108789795675493086L;
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private ManSort sort;// 联系人分类
	@Column(nullable = false)
	private Long dataId;// 记录ID
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_relation_id")
	private Category relation;// 关系
	@Column(nullable = false, length = 20)
	private String name;// 姓名
	@Column(length = 20)
	private String phone;// 电话
	@Column(length = 20)
	private String mobile;// 手机
	@Column(length = 20)
	private String qq;// QQ
	@Column(length = 50)
	private String email;// 邮箱
	@Column(length = 20)
	private String company;// 工作单位或部门
	@Column(length = 10)
	private String duty;// 职务

	public Linkman() {
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