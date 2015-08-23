package cn.com.kington.bean.buy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * 销售采购（物料采购）明细
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_buy_order_list")
public class BuyOrderList extends EntitySupport {
	private static final long serialVersionUID = 2646623160460869875L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_order_id")
	private BuyOrder order;// 所属订单
	private Long mateId;// 物料ID
	@Column(length = 50)
	private String name;// 名称
	@Column(length = 20)
	private String spec;// 规格
	@Column(length = 10)
	private String unit;// 单位
	@Column(scale = 2, precision = 12)
	private Double amount;// 数量
	@Column(scale = 2, precision = 12)
	private Double inAmount;// 已入库数量
	@Column(scale = 2, precision = 12)
	private Double price;// 单价
	@Column(length = 50)
	private String remark;// 备注

	public BuyOrderList() {
		super();
	}

	public BuyOrder getOrder() {
		return order;
	}

	public void setOrder(BuyOrder order) {
		this.order = order;
	}

	public Long getMateId() {
		return mateId;
	}

	public void setMateId(Long mateId) {
		this.mateId = mateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
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

	public Double getInAmount() {
		return inAmount;
	}

	public void setInAmount(Double inAmount) {
		this.inAmount = inAmount;
	}

}
