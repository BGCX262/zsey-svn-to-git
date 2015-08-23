package cn.com.kington.bean.finance;

import cn.com.kington.common.SOSupport;
import cn.com.kington.common.PublicType.Sort;

/**
 * 项目订单预算SO
 * 
 * @author 杜永生
 * 
 */
public class OrderBudgetSO extends SOSupport {
	private static final long serialVersionUID = 6896226242045948519L;
	private Sort sort;// 预算类型
	private String code;// 所属订单（采购）编号
	private Long dataId;// 所属订单明细（采购明细）ID
	private String name;// 名称
	private Double price;// 单价
	private String unit;// 单位
	private Double amount;// 数量
	private String remark;// 备注

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
