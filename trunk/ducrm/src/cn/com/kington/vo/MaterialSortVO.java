package cn.com.kington.vo;

import java.io.Serializable;

import cn.com.kington.bean.basic.Category;

public class MaterialSortVO implements Serializable {
	private static final long serialVersionUID = 6712580232354643770L;
	private Long id;
	private String code;// ���
	private String name;// ����
	private Category category;// ��������

	public MaterialSortVO() {
		super();
	}

	public MaterialSortVO(String code, String name, Category category) {
		super();
		this.code = code;
		this.name = name;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
