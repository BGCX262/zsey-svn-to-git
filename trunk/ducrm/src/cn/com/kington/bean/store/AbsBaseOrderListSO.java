package cn.com.kington.bean.store;

import cn.com.kington.common.SOSupport;

/**
 * ��ϸ����
 * 
 * @author ������
 * 
 */
public abstract class AbsBaseOrderListSO extends SOSupport {
	private static final long serialVersionUID = 1066908917700680392L;
	private Long proId;// ��ƷID
	private String code;// ��Ʒ���
	private String name;// ��Ʒ����
	private String size;// ����
	private String unit;// ��λ
	private Double price;// ��Ʒ����
	private Double amount;// ����
	private Double total;// ���
	private String remark;// ������ע

	public AbsBaseOrderListSO() {
		super();
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}
