package cn.com.kington.bean.basic;

import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.SOSupport;

/**
 * 物料
 * 
 * @author 杜永生
 * 
 */
public class MaterialSO extends SOSupport {
	private static final long serialVersionUID = 4026175569564412892L;
	private Provider provider;// 所属供应商
	private String code;// 编号
	private String name;// 名称
	private String spec;// 规格
	private SysDict unit;// 单位
	private Category category;// 所属分类
	private Double price;// 单价
	private String caption;// 备注

	public MaterialSO() {
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