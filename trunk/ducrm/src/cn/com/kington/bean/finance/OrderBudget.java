package cn.com.kington.bean.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.Sort;

/**
 * ��Ŀ����Ԥ��
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "xm_order_budget")
public class OrderBudget extends EntitySupport {
	private static final long serialVersionUID = 5483722801316213914L;
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Sort sort;// Ԥ������
	@Column(nullable = false, length = 15)
	private String code;// �����������ɹ������
	@Column(nullable = false, length = 15)
	private Long dataId;// ����������ϸ���ɹ���ϸ��ID
	@Column(nullable = false, length = 100)
	private String name;// ����
	@Column(nullable = false, scale = 2, precision = 12)
	private Double price;// ����
	@Column(nullable = false, length = 10)
	private String unit;// ��λ
	@Column(nullable = false, scale = 2, precision = 12)
	private Double amount;// ����
	@Column(length = 50)
	private String remark;// ��ע

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
