package cn.com.kington.bean.sell;

import cn.com.kington.bean.store.AbsBaseOrderListSO;

/**
 * 销售项目订单明细
 * 
 * @author 杜永生
 * 
 */
public class SellOrderListSO extends AbsBaseOrderListSO {
	private static final long serialVersionUID = -1541776995660474422L;
	private SellOrder order;// 所属订单

	public SellOrderListSO() {
		super();
	}

	public SellOrder getOrder() {
		return order;
	}

	public void setOrder(SellOrder order) {
		this.order = order;
	}

}
