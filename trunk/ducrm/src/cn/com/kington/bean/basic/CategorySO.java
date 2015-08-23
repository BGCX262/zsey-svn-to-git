package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;
import cn.com.kington.common.PublicType.Sort;

/**
 * ��������
 * 
 * @author ������
 * 
 */
public class CategorySO extends SOSupport {
	private static final long serialVersionUID = 3351166509064178967L;
	private String code;// ���
	private String name;// ����
	private Category category;// ��������
	private Sort sort;// ����

	public CategorySO() {
		super();
	}

	public CategorySO(String code, String name, Category category, Sort sort) {
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
