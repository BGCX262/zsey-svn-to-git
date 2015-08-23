package cn.com.kington.vo;

import java.io.Serializable;

import cn.com.kington.common.PublicType.OrderState;

public class AccessoryVO implements Serializable {
	private static final long serialVersionUID = -8700340294119143456L;
	private Long id;
	private Long dataId;// 记录ID
	private OrderState sort;// 类型
	private String name;// 文件名
	private String path;

	public AccessoryVO() {
		super();
	}

	public AccessoryVO(Long dataId, OrderState sort, String name, String path) {
		super();
		this.dataId = dataId;
		this.sort = sort;
		this.name = name;
		this.path = path;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public OrderState getSort() {
		return sort;
	}

	public void setSort(OrderState sort) {
		this.sort = sort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
