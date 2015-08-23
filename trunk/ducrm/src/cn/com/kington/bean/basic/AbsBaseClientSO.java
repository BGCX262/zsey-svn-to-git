package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * �ͻ�����Ӧ�̻�����Ϣ
 * 
 * @author ������
 * 
 */
public abstract class AbsBaseClientSO extends SOSupport {
	private static final long serialVersionUID = -7523546284774166872L;
	// ������Ϣ
	private String code;// ���
	private String name;// ����
	private String shortName;// ���
	private String web;// ��ַ
	// ��ϵ��ʽ
	private String fax;// ��λ����
	private String phone;// ��λ�绰
	private String qq;// QQ
	private String email;// ����
	private String linkman;// ��ϵ��
	private String tel;// ��ϵ�˵绰
	private String mobile;// ��ϵ���ֻ�
	private Area province;// ʡ��
	private Area city;// ����
	private String address;// ��ַ
	private String postcode;// �ʱ�
	// �����˺���Ϣ
	private String bcode;// �����˺�
	private String bname;// ��������
	private String bman;// ������
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
