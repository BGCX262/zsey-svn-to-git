package cn.com.kington.bean.sell;

import cn.com.kington.bean.store.AbsBaseOrderListSO;

/**
 * ��Ʒ������ϸ
 * 
 * @author ������
 * 
 */
public class ProductPriceListSO extends AbsBaseOrderListSO {
	private static final long serialVersionUID = -4694732658389686128L;
	private ProductPrice order;// ��������

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
