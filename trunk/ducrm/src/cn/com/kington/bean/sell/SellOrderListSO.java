package cn.com.kington.bean.sell;

import cn.com.kington.bean.store.AbsBaseOrderListSO;

/**
 * ������Ŀ������ϸ
 * 
 * @author ������
 * 
 */
public class SellOrderListSO extends AbsBaseOrderListSO {
	private static final long serialVersionUID = -1541776995660474422L;
	private SellOrder order;// ��������

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
