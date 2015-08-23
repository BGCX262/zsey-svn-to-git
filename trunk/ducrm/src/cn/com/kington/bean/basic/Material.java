package cn.com.kington.bean.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.system.SysDict;

/**
 * 物料
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "base_material")
public class Material extends EntitySupport {
	private static final long serialVersionUID = 6904315306157498049L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_provider_id")
	private Provider provider;// 所属供应商
	@Column(nullable = false, unique = true, length = 10)
	private String code;// 编号
	@Column(nullable = false, length = 50)
	private String name;// 名称
	@Column(length = 20)
	private String spec;// 规格
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_unit_id")
	private SysDict unit;// 单位
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_category_id")
	private Category category;// 所属分类
	@Column(scale = 2, precision = 12)
	private Double price;// 单价
	@Column(length = 50)
	private String caption;// 备注

	public Material() {
		super();
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public SysDict getUnit() {
		return unit;
	}

	public void setUnit(SysDict unit) {
		this.unit = unit;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

}
