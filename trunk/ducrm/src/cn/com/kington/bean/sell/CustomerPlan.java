package cn.com.kington.bean.sell;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.basic.Customer;
import cn.com.kington.bean.model.Employee;
import cn.com.kington.common.PublicType.PlanSort;

/**
 * �ͻ���Ϣ
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_customer_plan")
public class CustomerPlan extends EntitySupport {
	private static final long serialVersionUID = 5817352292924911469L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_employee_id")
	private Employee employee;// �����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer_id")
	private Customer customer;// �����ͻ�
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PlanSort sort; // ���
	@Column(nullable = false)
	@Basic(fetch = FetchType.LAZY)
	private String context;// ����

	public CustomerPlan() {
		super();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PlanSort getSort() {
		return sort;
	}

	public void setSort(PlanSort sort) {
		this.sort = sort;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
