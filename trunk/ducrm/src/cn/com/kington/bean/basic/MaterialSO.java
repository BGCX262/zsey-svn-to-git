package cn.com.kington.bean.basic;

import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.SOSupport;

/**
 * ����
 * 
 * @author ������
 * 
 */
public class MaterialSO extends SOSupport {
	private static final long serialVersionUID = 4026175569564412892L;
	private Provider provider;// ������Ӧ��
	private String code;// ���
	private String name;// ����
	private String spec;// ���
	private SysDict unit;// ��λ
	private Category category;// ��������
	private Double price;// ����
	private String caption;// ��ע

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