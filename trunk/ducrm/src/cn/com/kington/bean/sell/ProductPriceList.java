package cn.com.kington.bean.sell;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.store.AbsBaseOrderList;

/**
 * ��Ʒ������ϸ
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "xm_product_price_list")
public class ProductPriceList extends AbsBaseOrderList {
	private static final long serialVersionUID = 848685146217527592L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_order_id")
	private ProductPrice order;// ��������

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
