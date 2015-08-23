package cn.com.kington.bean.produce;

import cn.com.kington.bean.basic.Product;
import cn.com.kington.bean.model.Employee;
import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.common.SOSupport;

/**
 * ��������
 * 
 * @author ������
 * 
 */
public class WorkReportSO extends SOSupport {
	private static final long serialVersionUID = 2440774842653266763L;
	private Employee employee;// ����Ա��
	private Product product;// ������Ʒ
	private Long workId;// ����Id
	private String code;// ������
	private String name;// ����
	private Double amount;// ����
	private Double price;// �۸�
	private Double total;// ���
	private String addDate;// ����
	private StateType state;// ����״̬

	public WorkReportSO() {
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
