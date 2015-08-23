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
 * 员工工作月报告
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "bg_month_report")
public class MonthReport extends EntitySupport {
	private static final long serialVersionUID = 251786978228129033L;
	@Column(nullable = false)
	private Long empId;// 员工ID
	@Column(nullable = false)
	private String empCode;// 员工编号
	@Column(nullable = false)
	private String empName;// 员工姓名
	@Column(nullable = false)
	private Long departId;// 部门ID
	@Column(nullable = false)
	private String departName;// 部门名称
	private String workDate;// 工作月
	@Column(scale = 2, precision = 10)
	private BigDecimal workDays;// 上班天数
	@Column(scale = 2, precision = 10)
	private BigDecimal noDays;// 旷工天数
	@Column(scale = 2, precision = 10)
	private BigDecimal workHour;// 加班小时数
	@Column(scale = 2, precision = 10)
	private BigDecimal lateHour;// 迟到小时数
	@Column(scale = 2, precision = 10)
	private BigDecimal leaveHour;// 请假天数
	@Enumerated(EnumType.STRING)
	private BalanceStatus state;// 结算状态

	public MonthReport() {
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

	public BigDecimal getWorkDays() {
		return workDays;
	}

	public void setWorkDays(BigDecimal workDays) {
		this.workDays = workDays;
	}

	public BigDecimal getNoDays() {
		return noDays;
	}

	public void setNoDays(BigDecimal noDays) {
		this.noDays = noDays;
	}

	public BigDecimal getWorkHour() {
		return workHour;
	}

	public void setWorkHour(BigDecimal workHour) {
		this.workHour = workHour;
	}

	public BigDecimal getLateHour() {
		return lateHour;
	}

	public void setLateHour(BigDecimal lateHour) {
		this.lateHour = lateHour;
	}

	public BigDecimal getLeaveHour() {
		return leaveHour;
	}

	public void setLeaveHour(BigDecimal leaveHour) {
		this.leaveHour = leaveHour;
	}

	public BalanceStatus getState() {
		return state;
	}

	public void setState(BalanceStatus state) {
		this.state = state;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

}
