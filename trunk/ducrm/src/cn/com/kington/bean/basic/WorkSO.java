package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * ����
 * 
 * @author ������
 * 
 */
public class WorkSO extends SOSupport {
	private static final long serialVersionUID = -4549068028807630108L;
	private String code;// ���
	private String name;// ����
	private Double price;// ����
	private String remark;// ��ע

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