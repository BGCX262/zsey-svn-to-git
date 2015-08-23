package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * 工序
 * 
 * @author 杜永生
 * 
 */
public class WorkSO extends SOSupport {
	private static final long serialVersionUID = -4549068028807630108L;
	private String code;// 编号
	private String name;// 名称
	private Double price;// 单价
	private String remark;// 备注

	public WorkSO() {
		super();
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}