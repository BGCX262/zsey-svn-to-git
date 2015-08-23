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
import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.Department;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.PublicType.BloodSort;
import cn.com.kington.common.PublicType.Degree;
import cn.com.kington.common.PublicType.Sex;

/**
 * Ա��
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_employee")
public class Employee extends EntitySupport {
	private static final long serialVersionUID = 7562724307636514146L;
	// Ա��������Ϣ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_department_id")
	private Department department;// ��������
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_idtype_id")
	private SysDict idtype;// ֤������
	@Column(nullable = false, length = 20)
	private String idcard;// ֤�����
	@Column(nullable = false, unique = true, length = 10)
	private String code;// Ա�����
	@Column(nullable = false, length = 20)
	private String name;// ����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_duty_id")
	private SysDict duty;// ְ��
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Sex sex;// �Ա�
	@Column(length = 10)
	private String born;// ����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_nation_id")
	private SysDict nation;// ����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_polity_id")
	private SysDict polity;// ������ò
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private BloodSort blood;// Ѫ��
	@Column(length = 20)
	private String love;// ����
	@Column(length = 10)
	private String height;// ���
	@Column(length = 10)
	private String weight;// ����
	@Column(length = 255)
	private String photo;// ��Ƭ
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private Degree degree;// ѧ��
	@Column(length = 30)
	private String school;// ��ҵѧУ
	@Column(length = 30)
	private String specialty;// ��ѧרҵ
	// Ա����ϵ��ʽ
	@Column(length = 20)
	private String phone;// �绰
	@Column(length = 20)
	private String mobile;// �ֻ�
	@Column(length = 20)
	private String qq;// QQ
	@Column(length = 50)
	private String email;// ����
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
	// ����������Ϣ����Ա��������ʱʹ�ã�
	@Column(length = 30)
	private String bcode;// �����˺�
	@Column(length = 50)
	private String bname;// ��������
	@Column(length = 20)
	private String bman;// ������
	@Column(length = 100)
	private String badd;// ������ַ

	public Employee() {
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
