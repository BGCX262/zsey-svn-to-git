package cn.com.kington.bean.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.PublicType.ProductType;

/**
 * ��Ʒ
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_product")
public class Product extends EntitySupport {
	private static final long serialVersionUID = 7566827231221899101L;
	@Column(nullable = false, length = 50)
	private String name;// ����
	@Column(nullable = false, unique = true, length = 10)
	private String code;// ���
	@Column(nullable = false, scale = 2, precision = 12)
	private Double price;// ����
	@Column(scale = 2, precision = 12)
	private Double cost;// �ɱ�
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private ProductType type;// ��Ʒ����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_sort_id")
	private Category category;// ��������
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_unit_id")
	private SysDict unit;// ��λ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer_id")
	private Customer customer;// �����ͻ�

	public Product() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SysDict getUnit() {
		return unit;
	}

	public void setUnit(SysDict unit) {
		this.unit = unit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}
