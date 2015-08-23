package cn.com.kington.bean.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.Sex;

/**
 * Ա������ϵ�˻�����Ϣ
 * 
 * @author ������
 * 
 */
@MappedSuperclass
public abstract class AbsBaseMan extends EntitySupport {
	private static final long serialVersionUID = 3055639074970503906L;
	@Column(nullable = false, length = 20)
	private String name;// ����
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Sex sex;// �Ա�
	@Column(length = 20)
	private String phone;// �绰
	@Column(length = 20)
	private String mobile;// �ֻ�
	@Column(length = 20)
	private String qq;// QQ
	@Column(length = 50)
	private String email;// ����
	private String postcode;// �ʱ�

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
