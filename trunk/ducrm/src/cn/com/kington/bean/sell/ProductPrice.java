package cn.com.kington.bean.sell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.store.AbsBaseOrder;
import cn.com.kington.common.PublicType.AskStyle;
import cn.com.kington.common.PublicType.StateType;

/**
 * 产品报价
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_product_price")
public class ProductPrice extends AbsBaseOrder {
	private static final long serialVersionUID = -4398281966063555486L;
	@Column(length = 12)
	@Enumerated(EnumType.STRING)
	private StateType ask;// 报价确认
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private AskStyle style;// 报价方式

	public ProductPrice() {
		super();
	}

	public StateType getAsk() {
		return ask;
	}

	public void setAsk(StateType ask) {
		this.ask = ask;
	}

	public AskStyle getStyle() {
		return style;
	}

	public void setStyle(AskStyle style) {
		this.style = style;
	}

}
