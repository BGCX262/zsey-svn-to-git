package cn.com.kington.bean.model;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.Department;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.PublicType.BloodSort;
import cn.com.kington.common.PublicType.Degree;
import cn.com.kington.common.PublicType.Sex;
import cn.com.kington.common.SOSupport;

/**
 * 员工
 * 
 * @author 杜永生
 * 
 */
public class EmployeeSO extends SOSupport {
	private static final long serialVersionUID = -4762458231676776648L;
	// 员工基本信息
	private Department department;// 所属部门
	private SysDict idtype;// 证件类型
	private String idcard;// 证件编号
	private String code;// 员工编号
	private String name;// 姓名
	private SysDict duty;// 职务
	private Sex sex;// 性别
	private String born;// 生日
	private SysDict nation;// 民族
	private SysDict polity;// 政治面貌
	private BloodSort blood;// 血型
	private String love;// 爱好
	private String height;// 身高
	private String weight;// 体重
	private String photo;// 相片
	private Degree degree;// 学历
	private String school;// 毕业学校
	private String specialty;// 所学专业
	// 员工联系方式
	private String phone;// 电话
	private String mobile;// 手机
	private String qq;// QQ
	private String email;// 邮箱
	private Area province;// 省份
	private Area city;// 城市
	private String address;// 地址
	private String postcode;// 邮编
	// 银行账务信息（给员工发工资时使用）
	private String bcode;// 银行账号
	private String bname;// 银行名称
	private String bman;// 开户人
	private String badd;// 开户地址

	public EmployeeSO() {
		super();
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public SysDict getIdtype() {
		return idtype;
	}

	public void setIdtype(SysDict idtype) {
		this.idtype = idtype;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
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

	public SysDict getDuty() {
		return duty;
	}

	public void setDuty(SysDict duty) {
		this.duty = duty;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public SysDict getNation() {
		return nation;
	}

	public void setNation(SysDict nation) {
		this.nation = nation;
	}

	public SysDict getPolity() {
		return polity;
	}

	public void setPolity(SysDict polity) {
		this.polity = polity;
	}

	public BloodSort getBlood() {
		return blood;
	}

	public void setBlood(BloodSort blood) {
		this.blood = blood;
	}

	public String getLove() {
		return love;
	}

	public void setLove(String love) {
		this.love = love;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

}
