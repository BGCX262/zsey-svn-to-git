package cn.com.kington.bean.produce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * 产品物料
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_product_mate")
public class ProductMaterial extends EntitySupport {
	private static final long serialVersionUID = -3316839315024658248L;
	@Column(nullable = false)
	private Long proId;// 产品ID
	@Column(nullable = false)
	private Long mateId;// 物料Id
	@Column(nullable = false, length = 10)
	private String code;// 物料编号
	@Column(nullable = false, length = 60)
	private String name;// 物料名称及规格
	@Column(nullable = false, scale = 2, precision = 12)
	private Double amount;// 数量
	@Column(nullable = false, scale = 2, precision = 12)
	private Double price;// 价格
	@Column(nullable = false, scale = 2, precision = 12)
	private Double total;// 金额
	@Column(nullable = false, length = 10)
	private String unit;// 单位

	public ProductMaterial() {
		super();
	}

	public ProductMaterial(Long proId, Long mateId, String code, String name,
			Double amount, Double price, Double total, String unit) {
		super();
		this.proId = proId;
		this.mateId = mateId;
		this.code = code;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.total = total;
		this.unit = unit;
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public Long getMateId() {
		return mateId;
	}

	public void setMateId(Long mateId) {
		this.mateId = mateId;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
