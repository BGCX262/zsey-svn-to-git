package cn.com.kington.bean.model;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.Department;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.PublicType.BloodSort;
import cn.com.kington.common.PublicType.Degree;
import cn.com.kington.common.PublicType.Sex;
import cn.com.kington.common.SOSupport;

/**
 * Ա��
 * 
 * @author ������
 * 
 */
public class EmployeeSO extends SOSupport {
	private static final long serialVersionUID = -4762458231676776648L;
	// Ա��������Ϣ
	private Department department;// ��������
	private SysDict idtype;// ֤������
	private String idcard;// ֤�����
	private String code;// Ա�����
	private String name;// ����
	private SysDict duty;// ְ��
	private Sex sex;// �Ա�
	private String born;// ����
	private SysDict nation;// ����
	private SysDict polity;// ������ò
	private BloodSort blood;// Ѫ��
	private String love;// ����
	private String height;// ���
	private String weight;// ����
	private String photo;// ��Ƭ
	private Degree degree;// ѧ��
	private String school;// ��ҵѧУ
	private String specialty;// ��ѧרҵ
	// Ա����ϵ��ʽ
	private String phone;// �绰
	private String mobile;// �ֻ�
	private String qq;// QQ
	private String email;// ����
	private Area province;// ʡ��
	private Area city;// ����
	private String address;// ��ַ
	private String postcode;// �ʱ�
	// ����������Ϣ����Ա��������ʱʹ�ã�
	private String bcode;// �����˺�
	private String bname;// ��������
	private String bman;// ������
	private String badd;// ������ַ

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
