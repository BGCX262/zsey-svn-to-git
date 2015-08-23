package cn.com.kington.bean.sell;

import cn.com.kington.bean.store.AbsBaseOrderSO;
import cn.com.kington.common.PublicType.AskStyle;
import cn.com.kington.common.PublicType.StateType;

/**
 * 产品报价
 * 
 * @author 杜永生
 * 
 */
public class ProductPriceSO extends AbsBaseOrderSO {
	private static final long serialVersionUID = -1781692946414395461L;
	private StateType ask;// 报价确认
	private AskStyle style;// 报价方式

	public ProductPriceSO() {
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
