package cn.com.kington.bean.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.Sort;

/**
 * ��������
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_category", uniqueConstraints = @UniqueConstraint(columnNames = {"code", "sort" }))
public class Category extends EntitySupport {
	private static final long serialVersionUID = 3351166509064178967L;
	@Column(nullable = false)
	private String code;// ���
	@Column(nullable = false)
	private String name;// ����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_category_id")
	private Category category;// ��������
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Sort sort;// ����

	public Category() {
		super();
	}

	public Category(String code, String name, Category category, Sort sort) {
		super();
		this.code = code;
		this.name = name;
		this.category = category;
		this.sort = sort;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

}
