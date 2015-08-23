package cn.com.kington.bean.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.BalanceStatus;

/**
 * Ա�������ձ��棨�򿨼�¼��
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "bg_day_report")
public class DayReport extends EntitySupport {
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
	private String mornStart;// �����ϰ�ʱ��
	private String mornEnd;// �����°�ʱ��
	private String afterStart;// �����ϰ�ʱ��
	private String afterEnd;// �����°�ʱ��
	private String nightStart;// �����ϰ�ʱ��
	private String nightEnd;// �����°�ʱ��
	@Enumerated(EnumType.STRING)
	private BalanceStatus state;// ����״̬

	public DayReport() {
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

	public String getMornStart() {
		return mornStart;
	}

	public void setMornStart(String mornStart) {
		this.mornStart = mornStart;
	}

	public String getMornEnd() {
		return mornEnd;
	}

	public void setMornEnd(String mornEnd) {
		this.mornEnd = mornEnd;
	}

	public String getAfterStart() {
		return afterStart;
	}

	public void setAfterStart(String afterStart) {
		this.afterStart = afterStart;
	}

	public String getAfterEnd() {
		return afterEnd;
	}

	public void setAfterEnd(String afterEnd) {
		this.afterEnd = afterEnd;
	}

	public String getNightStart() {
		return nightStart;
	}

	public void setNightStart(String nightStart) {
		this.nightStart = nightStart;
	}

	public String getNightEnd() {
		return nightEnd;
	}

	public void setNightEnd(String nightEnd) {
		this.nightEnd = nightEnd;
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
