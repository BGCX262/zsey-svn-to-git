package cn.com.kington.bean.basic;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import cn.com.kington.bean.EntitySupport;

/**
 * �ͻ�����Ӧ�̻�����Ϣ
 * 
 * @author ������
 * 
 */
@MappedSuperclass
public abstract class AbsBaseClient extends EntitySupport {
	private static final long serialVersionUID = -7523546284774166872L;
	// ������Ϣ
	@Column(nullable = false, unique = true, length = 10)
	private String code;// ���
	@Column(nullable = false, length = 50)
	private String name;// ����
	@Column(length = 20)
	private String shortName;// ���
	@Column(length = 50)
	private String web;// ��ַ
	// ��ϵ��ʽ
	@Column(length = 20)
	private String fax;// ��λ����
	@Column(length = 20)
	private String phone;// ��λ�绰
	@Column(length = 20)
	private String qq;// QQ
	@Column(length = 50)
	private String email;// ����
	@Column(length = 20)
	private String linkman;// ��ϵ��
	@Column(length = 20)
	private String tel;// ��ϵ�˵绰
	@Column(length = 20)
	private String mobile;// ��ϵ���ֻ�
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_province_id")
	private Area province;// ʡ��
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_city_id")
	private Area city;// ����
	@Column(length = 30)
	private String address;// ��ַ
	@Column(length = 6)
	private String postcode;// �ʱ�
	// �����˺���Ϣ
	@Column(length = 30)
	private String bcode;// �����˺�
	@Column(length = 50)
	private String bname;// ��������
	@Column(length = 20)
	private String bman;// ������
	@Column(length = 255)
	private String badd;// ���е�ַ

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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Area getProvince() {
		return province;
	}

	public void setProvince(Area province) {
		this.province = province;
	}

	public Area getCity() {
		return city;
	}

	public void setCity(Area city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBman() {
		return bman;
	}

	public void setBman(String bman) {
		this.bman = bman;
	}

	public String getBadd() {
		return badd;
	}

	public void setBadd(String badd) {
		this.badd = badd;
	}

}
