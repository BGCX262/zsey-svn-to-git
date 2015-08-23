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
 * 员工工资报表
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "bg_wage_report")
public class WageReport extends EntitySupport {
	private static final long serialVersionUID = 8912916532219549647L;
	@Column(nullable=false)
	private Long empId;// 员工ID
	@Column(nullable=false)
	private String empCode;// 员工编号
	@Column(nullable=false)
	private String empName;// 员工姓名
	@Column(nullable=false)
	private Long departId;// 部门ID
	@Column(nullable=false)
	private String departName;// 部门名称
	@Column(scale = 2, precision = 10)
	private BigDecimal basic;// 基本工资
	@Column(scale = 2, precision = 10)
	private BigDecimal percent;// 提成
	@Column(scale = 2, precision = 10)
	private BigDecimal countwork;// 计件工资
	@Column(scale = 2, precision = 10)
	private BigDecimal timework;// 计时工资
	@Column(scale = 2, precision = 10)
	private BigDecimal overtime;// 加班费
	@Column(scale = 2, precision = 10)
	private BigDecimal allowance;// 补贴、津贴、伙费补贴及生活补贴
	@Column(scale = 2, precision = 10)
	private BigDecimal bonus;// 奖金（包括全勤奖）
	@Column(scale = 2, precision = 10)
	private BigDecimal amerce;// 罚金
	@Column(scale = 2, precision = 10)
	private BigDecimal revenue;// 个人所得税
	@Column(scale = 2, precision = 10)
	private BigDecimal insurance;// 社保
	@Column(scale = 2, precision = 10)
	private BigDecimal should;// 应发工资
	@Column(scale = 2, precision = 10)
	private BigDecimal fact;// 实发工资
	@Enumerated(EnumType.STRING)
	private BalanceStatus state;// 结算状态

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
