package cn.com.kington.bean.basic;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import cn.com.kington.bean.EntitySupport;

/**
 * 客户、供应商基本信息
 * 
 * @author 杜永生
 * 
 */
@MappedSuperclass
public abstract class AbsBaseClient extends EntitySupport {
	private static final long serialVersionUID = -7523546284774166872L;
	// 基本信息
	@Column(nullable = false, unique = true, length = 10)
	private String code;// 编号
	@Column(nullable = false, length = 50)
	private String name;// 名称
	@Column(length = 20)
	private String shortName;// 简称
	@Column(length = 50)
	private String web;// 网址
	// 联系方式
	@Column(length = 20)
	private String fax;// 单位传真
	@Column(length = 20)
	private String phone;// 单位电话
	@Column(length = 20)
	private String qq;// QQ
	@Column(length = 50)
	private String email;// 邮箱
	@Column(length = 20)
	private String linkman;// 联系人
	@Column(length = 20)
	private String tel;// 联系人电话
	@Column(length = 20)
	private String mobile;// 联系人手机
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_province_id")
	private Area province;// 省份
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_city_id")
	private Area city;// 城市
	@Column(length = 30)
	private String address;// 地址
	@Column(length = 6)
	private String postcode;// 邮编
	// 银行账号信息
	@Column(length = 30)
	private String bcode;// 银行账号
	@Column(length = 50)
	private String bname;// 银行名称
	@Column(length = 20)
	private String bman;// 开户人
	@Column(length = 255)
	private String badd;// 银行地址

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
