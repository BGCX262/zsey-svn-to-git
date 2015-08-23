package cn.com.kington.bean.produce;

import cn.com.kington.bean.basic.Product;
import cn.com.kington.common.SOSupport;

/**
 * ��Ʒ����
 * 
 * @author ������
 * 
 */
public class ProductWorkSO extends SOSupport {
	private static final long serialVersionUID = 2268993407417313564L;
	private Product product;// ������Ʒ
	private Long workId;// ����Id
	private String code;// ������
	private String name;// ����
	private Double amount;// ����
	private Double price;// �۸�
	private Double total;// ���

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
