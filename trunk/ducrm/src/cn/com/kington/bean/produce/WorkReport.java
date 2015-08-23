package cn.com.kington.bean.produce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.basic.Product;
import cn.com.kington.bean.model.Employee;
import cn.com.kington.common.PublicType.StateType;

/**
 * 工作报告
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_work_report")
public class WorkReport extends EntitySupport {
	private static final long serialVersionUID = -5741484872699340610L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_employee_id")
	private Employee employee;// 所属员工
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product_id")
	private Product product;// 所属产品
	private Long workId;// 工序Id
	@Column(length = 10)
	private String code;// 工序编号
	@Column(length = 60)
	private String name;// 名称
	@Column(scale = 2, precision = 12)
	private Double amount;// 数量
	@Column(scale = 2, precision = 12)
	private Double price;// 价格
	@Column(scale = 2, precision = 12)
	private Double total;// 金额
	@Column(length = 10)
	private String addDate;// 日期
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private StateType state;// 结算状态

	public WorkReport() {
		super();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getWorkId() {
		return workId;
	}

	public void setWorkId(Long workId) {
		this.workId = workId;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

}
