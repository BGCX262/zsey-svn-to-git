package cn.com.kington.bean.basic;

import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.PublicType.ProductType;
import cn.com.kington.common.SOSupport;

/**
 * ��Ʒ����
 * 
 * @author ������
 * 
 */
public class ProductSO extends SOSupport {
	private static final long serialVersionUID = 878643917246643599L;
	private String name;// ����
	private String code;// ���
	private Double price;// ����
	private Double cost;// �ɱ�
	private ProductType type;// ��Ʒ����
	private Category category;// ��������
	private SysDict unit;// ��λ
	private Customer customer;// �����ͻ�

	public ProductSO() {
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
