package cn.com.kington.bean.sell;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.store.AbsBaseOrderList;

/**
 * 产品报价明细
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_product_price_list")
public class ProductPriceList extends AbsBaseOrderList {
	private static final long serialVersionUID = 848685146217527592L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_order_id")
	private ProductPrice order;// 所属订单

	public ProductPriceList() {
		super();
	}

	public ProductPrice getOrder() {
		return order;
	}

	public void setOrder(ProductPrice order) {
		this.order = order;
	}

}
