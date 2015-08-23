package cn.com.kington.bean.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.basic.Area;

/**
 * ϵͳ����
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "sys_cfg")
public class SysConfig extends EntitySupport {
	private static final long serialVersionUID = -4475957656204379660L;
	@Column(length = 50)
	private String name;// ����
	@Column(length = 50)
	private String web;// ��ַ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_province_id")
	private Area province;// ʡ��
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_city_id")
	private Area city;// ����
	@Column(length = 50)
	private String address;// ��ַ
	@Column(length = 6)
	private String postcode;// �ʱ�
	@Column(length = 20)
	private String phone1;// �绰1
	@Column(length = 20)
	private String phone2;// �绰2
	@Column(length = 20)
	private String fax1;// ����1
	@Column(length = 20)
	private String fax2;// ����2
	@Column(length = 20)
	private String qq1;// QQ1
	@Column(length = 20)
	private String qq2;// QQ2
	@Column(length = 50)
	private String email1;// ����1
	@Column(length = 50)
	private String email2;// ����2
	@Column(length = 50)
	private String linkman1;// ��ϵ��1
	@Column(length = 10)
	private String linkman2;// ��ϵ��2
	@Column(length = 20)
	private String tel1;// ��ϵ�˵绰1
	@Column(length = 20)
	private String tel2;// ��ϵ�˵绰2
	@Column(length = 11)
	private String mobile1;// ��ϵ���ֻ�2
	@Column(length = 11)
	private String mobile2;// ��ϵ���ֻ�2
	@Column(length = 30)
	private String bcode1;// �����˺�1
	@Column(length = 30)
	private String bname1;// ��������1
	@Column(length = 30)
	private String bman1;// ������1
	@Column(length = 50)
	private String badd1;// ���е�ַ1
	@Column(length = 30)
	private String bcode2;// �����˺�2
	@Column(length = 30)
	private String bname2;// ��������2
	@Column(length = 30)
	private String bman2;// ������2
	@Column(length = 50)
	private String badd2;// ���е�ַ2

	public SysConfig() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax1() {
		return fax1;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	public String getFax2() {
		return fax2;
	}

	public void setFax2(String fax2) {
		this.fax2 = fax2;
	}

	public String getQq1() {
		return qq1;
	}

	public void setQq1(String qq1) {
		this.qq1 = qq1;
	}

	public String getQq2() {
		return qq2;
	}

	public void setQq2(String qq2) {
		this.qq2 = qq2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getLinkman1() {
		return linkman1;
	}

	public void setLinkman1(String linkman1) {
		this.linkman1 = linkman1;
	}

	public String getLinkman2() {
		return linkman2;
	}

	public void setLinkman2(String linkman2) {
		this.linkman2 = linkman2;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getBcode1() {
		return bcode1;
	}

	public void setBcode1(String bcode1) {
		this.bcode1 = bcode1;
	}

	public String getBname1() {
		return bname1;
	}

	public void setBname1(String bname1) {
		this.bname1 = bname1;
	}

	public String getBman1() {
		return bman1;
	}

	public void setBman1(String bman1) {
		this.bman1 = bman1;
	}

	public String getBadd1() {
		return badd1;
	}

	public void setBadd1(String badd1) {
		this.badd1 = badd1;
	}

	public String getBcode2() {
		return bcode2;
	}

	public void setBcode2(String bcode2) {
		this.bcode2 = bcode2;
	}

	public String getBname2() {
		return bname2;
	}

	public void setBname2(String bname2) {
		this.bname2 = bname2;
	}

	public String getBman2() {
		return bman2;
	}

	public void setBman2(String bman2) {
		this.bman2 = bman2;
	}

	public String getBadd2() {
		return badd2;
	}

	public void setBadd2(String badd2) {
		this.badd2 = badd2;
	}

}
