package cn.com.kington.bean.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.BalanceStatus;

/**
 * 员工生产报告
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "bg_produce_report")
public class ProduceReport extends EntitySupport {
	private static final long serialVersionUID = 2317054926957285132L;
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
	private String workDate;// 工作日
	private Long orderId;// 所属生产的销售订单（项目）ID
	private Long proId;// 所属生产的产品的ID
	private String proName;// 所属生产的产品名称
	private Long workId;// 所属产品工序的ID
	private String workName;// 所属产品工序名称
	private String price;// 所属产品工序单价
	private Integer amount;// 数量
	@Enumerated(EnumType.STRING)
	private BalanceStatus state;// 结算状态

	public ProduceReport() {
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

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Long getWorkId() {
		return workId;
	}

	public void setWorkId(Long workId) {
		this.workId = workId;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BalanceStatus getState() {
		return state;
	}

	public void setState(BalanceStatus state) {
		this.state = state;
	}

}
