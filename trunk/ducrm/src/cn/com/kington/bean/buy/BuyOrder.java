package cn.com.kington.bean.buy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.store.AbsBaseOrder;
import cn.com.kington.common.PublicType.StateType;

/**
 * 销售采购（物料采购）
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_buy_order")
public class BuyOrder extends AbsBaseOrder {
	private static final long serialVersionUID = -6372779145943499770L;
	private String deliver;// 交付日期
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private StateType balanceState;// 结算状态
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private StateType inState;// 入库状态
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private StateType backState;// 退状态
	@Column(length = 50)
	private String cause;//退回原因

	public BuyOrder() {
		super();
	}

	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public StateType getBalanceState() {
		return balanceState;
	}

	public void setBalanceState(StateType balanceState) {
		this.balanceState = balanceState;
	}

	public StateType getInState() {
		return inState;
	}

	public void setInState(StateType inState) {
		this.inState = inState;
	}

	public StateType getBackState() {
		return backState;
	}

	public void setBackState(StateType backState) {
		this.backState = backState;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

}
