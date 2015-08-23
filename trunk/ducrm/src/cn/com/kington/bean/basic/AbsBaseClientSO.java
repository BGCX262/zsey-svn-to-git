package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * 客户、供应商基本信息
 * 
 * @author 杜永生
 * 
 */
public abstract class AbsBaseClientSO extends SOSupport {
	private static final long serialVersionUID = -7523546284774166872L;
	// 基本信息
	private String code;// 编号
	private String name;// 名称
	private String shortName;// 简称
	private String web;// 网址
	// 联系方式
	private String fax;// 单位传真
	private String phone;// 单位电话
	private String qq;// QQ
	private String email;// 邮箱
	private String linkman;// 联系人
	private String tel;// 联系人电话
	private String mobile;// 联系人手机
	private Area province;// 省份
	private Area city;// 城市
	private String address;// 地址
	private String postcode;// 邮编
	// 银行账号信息
	private String bcode;// 银行账号
	private String bname;// 银行名称
	private String bman;// 开户人
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
