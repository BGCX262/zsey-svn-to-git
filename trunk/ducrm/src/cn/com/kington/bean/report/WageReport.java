package cn.com.kington.bean.report;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.BalanceStatus;

/**
 * Ա�����ʱ���
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "bg_wage_report")
public class WageReport extends EntitySupport {
	private static final long serialVersionUID = 8912916532219549647L;
	@Column(nullable=false)
	private Long empId;// Ա��ID
	@Column(nullable=false)
	private String empCode;// Ա�����
	@Column(nullable=false)
	private String empName;// Ա������
	@Column(nullable=false)
	private Long departId;// ����ID
	@Column(nullable=false)
	private String departName;// ��������
	@Column(scale = 2, precision = 10)
	private BigDecimal basic;// ��������
	@Column(scale = 2, precision = 10)
	private BigDecimal percent;// ���
	@Column(scale = 2, precision = 10)
	private BigDecimal countwork;// �Ƽ�����
	@Column(scale = 2, precision = 10)
	private BigDecimal timework;// ��ʱ����
	@Column(scale = 2, precision = 10)
	private BigDecimal overtime;// �Ӱ��
	@Column(scale = 2, precision = 10)
	private BigDecimal allowance;// ��������������Ѳ����������
	@Column(scale = 2, precision = 10)
	private BigDecimal bonus;// ���𣨰���ȫ�ڽ���
	@Column(scale = 2, precision = 10)
	private BigDecimal amerce;// ����
	@Column(scale = 2, precision = 10)
	private BigDecimal revenue;// ��������˰
	@Column(scale = 2, precision = 10)
	private BigDecimal insurance;// �籣
	@Column(scale = 2, precision = 10)
	private BigDecimal should;// Ӧ������
	@Column(scale = 2, precision = 10)
	private BigDecimal fact;// ʵ������
	@Enumerated(EnumType.STRING)
	private BalanceStatus state;// ����״̬

	public WageReport() {
		super();
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getDepartId() {
		return departId;
	}

	public void setDepartId(Long departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public BigDecimal getBasic() {
		return basic;
	}

	public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public BigDecimal getCountwork() {
		return countwork;
	}

	public void setCountwork(BigDecimal countwork) {
		this.countwork = countwork;
	}

	public BigDecimal getTimework() {
		return timework;
	}

	public void setTimework(BigDecimal timework) {
		this.timework = timework;
	}

	public BigDecimal getOvertime() {
		return overtime;
	}

	public void setOvertime(BigDecimal overtime) {
		this.overtime = overtime;
	}

	public BigDecimal getAllowance() {
		return allowance;
	}

	public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getAmerce() {
		return amerce;
	}

	public void setAmerce(BigDecimal amerce) {
		this.amerce = amerce;
	}

	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public BigDecimal getInsurance() {
		return insurance;
	}

	public void setInsurance(BigDecimal insurance) {
		this.insurance = insurance;
	}

	public BigDecimal getShould() {
		return should;
	}

	public void setShould(BigDecimal should) {
		this.should = should;
	}

	public BigDecimal getFact() {
		return fact;
	}

	public void setFact(BigDecimal fact) {
		this.fact = fact;
	}

	public BalanceStatus getState() {
		return state;
	}

	public void setState(BalanceStatus state) {
		this.state = state;
	}

}
