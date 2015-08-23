package cn.com.kington.bean.sell;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.store.AbsBaseOrderList;

/**
 * 销售订单（项目）明细
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_sell_order_list")
public class SellOrderList extends AbsBaseOrderList {
	private static final long serialVersionUID = -5745508087283143156L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_order_id")
	private SellOrder order;// 所属订单

	public SellOrderList() {
		super();
	}

	public SellOrder getOrder() {
		return order;
	}

	public void setOrder(SellOrder order) {
		this.order = order;
	}

}
