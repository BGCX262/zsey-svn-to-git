package cn.com.kington.bean.finance;

import cn.com.kington.common.SOSupport;
import cn.com.kington.common.PublicType.Sort;

/**
 * ��Ŀ����Ԥ��SO
 * 
 * @author ������
 * 
 */
public class OrderBudgetSO extends SOSupport {
	private static final long serialVersionUID = 6896226242045948519L;
	private Sort sort;// Ԥ������
	private String code;// �����������ɹ������
	private Long dataId;// ����������ϸ���ɹ���ϸ��ID
	private String name;// ����
	private Double price;// ����
	private String unit;// ��λ
	private Double amount;// ����
	private String remark;// ��ע

	public OrderBudgetSO() {
		super();
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
