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
 * Ա�������±���
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "bg_month_report")
public class MonthReport extends EntitySupport {
	private static final long serialVersionUID = 251786978228129033L;
	@Column(nullable = false)
	private Long empId;// Ա��ID
	@Column(nullable = false)
	private String empCode;// Ա�����
	@Column(nullable = false)
	private String empName;// Ա������
	@Column(nullable = false)
	private Long departId;// ����ID
	@Column(nullable = false)
	private String departName;// ��������
	private String workDate;// ������
	@Column(scale = 2, precision = 10)
	private BigDecimal workDays;// �ϰ�����
	@Column(scale = 2, precision = 10)
	private BigDecimal noDays;// ��������
	@Column(scale = 2, precision = 10)
	private BigDecimal workHour;// �Ӱ�Сʱ��
	@Column(scale = 2, precision = 10)
	private BigDecimal lateHour;// �ٵ�Сʱ��
	@Column(scale = 2, precision = 10)
	private BigDecimal leaveHour;// �������
	@Enumerated(EnumType.STRING)
	private BalanceStatus state;// ����״̬

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
