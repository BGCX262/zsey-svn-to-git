package cn.com.kington.bean.sell;

import cn.com.kington.bean.store.AbsBaseOrderListSO;

/**
 * 产品报价明细
 * 
 * @author 杜永生
 * 
 */
public class ProductPriceListSO extends AbsBaseOrderListSO {
	private static final long serialVersionUID = -4694732658389686128L;
	private ProductPrice order;// 所属订单

	public ProductPriceListSO() {
		super();
	}

	public ProductPrice getOrder() {
		return order;
	}

	public void setOrder(ProductPrice order) {
		this.order = order;
	}

}
