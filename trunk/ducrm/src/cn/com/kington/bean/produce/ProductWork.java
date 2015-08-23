package cn.com.kington.bean.produce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.basic.Product;

/**
 * 产品物料
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_product_work")
public class ProductWork extends EntitySupport {
	private static final long serialVersionUID = -3316839315024658248L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "fk_product_id")
	private Product product;// 所属产品
	@Column(nullable = false)
	private Long workId;// 工序Id
	@Column(nullable = false, length = 10)
	private String code;// 工序编号
	@Column(nullable = false, length = 60)
	private String name;// 名称
	@Column(nullable = false, scale = 2, precision = 12)
	private Double amount;// 数量
	@Column(nullable = false, scale = 2, precision = 12)
	private Double price;// 价格
	@Column(nullable = false, scale = 2, precision = 12)
	private Double total;// 金额

	public ProductWork() {
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
