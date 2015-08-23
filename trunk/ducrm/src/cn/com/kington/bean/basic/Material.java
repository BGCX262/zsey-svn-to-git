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
 * ����
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_material")
public class Material extends EntitySupport {
	private static final long serialVersionUID = 6904315306157498049L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_provider_id")
	private Provider provider;// ������Ӧ��
	@Column(nullable = false, unique = true, length = 10)
	private String code;// ���
	@Column(nullable = false, length = 50)
	private String name;// ����
	@Column(length = 20)
	private String spec;// ���
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_unit_id")
	private SysDict unit;// ��λ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_category_id")
	private Category category;// ��������
	@Column(scale = 2, precision = 12)
	private Double price;// ����
	@Column(length = 50)
	private String caption;// ��ע

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
