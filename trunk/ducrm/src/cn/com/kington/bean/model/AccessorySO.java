package cn.com.kington.bean.model;

import cn.com.kington.common.SOSupport;
import cn.com.kington.common.PublicType.OrderState;

/**
 * 附件
 * 
 * @author 杜永生
 * 
 */
public class AccessorySO extends SOSupport {
	private static final long serialVersionUID = -3335970476267587572L;
	private Long dataId;// 记录ID
	private OrderState sort;// 类型
	private String name;// 文件名
	private String path;
	private Long userid;
	private String realname;

	public AccessorySO() {
		super();
	}

	public AccessorySO(Long dataId, OrderState sort, String name, String path,
			Long userid, String realname) {
		super();
		this.dataId = dataId;
		this.sort = sort;
		this.name = name;
		this.path = path;
		this.userid = userid;
		this.realname = realname;
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

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}
