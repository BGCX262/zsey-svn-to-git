package cn.com.kington.bean.basic;

import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.PublicType.ProductType;
import cn.com.kington.common.SOSupport;

/**
 * 产品管理
 * 
 * @author 杜永生
 * 
 */
public class ProductSO extends SOSupport {
	private static final long serialVersionUID = 878643917246643599L;
	private String name;// 名称
	private String code;// 编号
	private Double price;// 单价
	private Double cost;// 成本
	private ProductType type;// 产品类型
	private Category category;// 所属分类
	private SysDict unit;// 单位
	private Customer customer;// 所属客户

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
