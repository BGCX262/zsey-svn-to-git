package cn.com.kington.bean.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.Sort;

/**
 * 项目订单预算
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_order_budget")
public class OrderBudget extends EntitySupport {
	private static final long serialVersionUID = 5483722801316213914L;
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Sort sort;// 预算类型
	@Column(nullable = false, length = 15)
	private String code;// 所属订单（采购）编号
	@Column(nullable = false, length = 15)
	private Long dataId;// 所属订单明细（采购明细）ID
	@Column(nullable = false, length = 100)
	private String name;// 名称
	@Column(nullable = false, scale = 2, precision = 12)
	private Double price;// 单价
	@Column(nullable = false, length = 10)
	private String unit;// 单位
	@Column(nullable = false, scale = 2, precision = 12)
	private Double amount;// 数量
	@Column(length = 50)
	private String remark;// 备注

	public OrderBudget() {
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
