package cn.com.kington.bean.buy;

import cn.com.kington.bean.store.AbsBaseOrderSO;
import cn.com.kington.common.PublicType.AskStyle;

/**
 * 采购（物料）询价
 * 
 * @author 杜永生
 * 
 */
public class BuyPriceSO extends AbsBaseOrderSO {
	private static final long serialVersionUID = -7007500497548803393L;
	private AskStyle style;// 询价方式

	public BuyPriceSO() {
		super();
	}

	public AskStyle getStyle() {
		return style;
	}

	public void setStyle(AskStyle style) {
		this.style = style;
	}

}
