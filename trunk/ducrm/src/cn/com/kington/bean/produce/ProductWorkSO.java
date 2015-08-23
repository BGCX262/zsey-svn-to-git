package cn.com.kington.bean.produce;

import cn.com.kington.bean.basic.Product;
import cn.com.kington.common.SOSupport;

/**
 * 产品物料
 * 
 * @author 杜永生
 * 
 */
public class ProductWorkSO extends SOSupport {
	private static final long serialVersionUID = 2268993407417313564L;
	private Product product;// 所属产品
	private Long workId;// 工序Id
	private String code;// 工序编号
	private String name;// 名称
	private Double amount;// 数量
	private Double price;// 价格
	private Double total;// 金额

	public ProductWorkSO() {
		super();
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

}
