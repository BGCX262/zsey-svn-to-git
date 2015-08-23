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
 * ��������
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "xm_work_report")
public class WorkReport extends EntitySupport {
	private static final long serialVersionUID = -5741484872699340610L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_employee_id")
	private Employee employee;// ����Ա��
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product_id")
	private Product product;// ������Ʒ
	private Long workId;// ����Id
	@Column(length = 10)
	private String code;// ������
	@Column(length = 60)
	private String name;// ����
	@Column(scale = 2, precision = 12)
	private Double amount;// ����
	@Column(scale = 2, precision = 12)
	private Double price;// �۸�
	@Column(scale = 2, precision = 12)
	private Double total;// ���
	@Column(length = 10)
	private String addDate;// ����
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private StateType state;// ����״̬

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
