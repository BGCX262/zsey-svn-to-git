package cn.com.kington.bean.sell;

import cn.com.kington.bean.store.AbsBaseOrderSO;
import cn.com.kington.common.PublicType.AskStyle;
import cn.com.kington.common.PublicType.StateType;

/**
 * ��Ʒ����
 * 
 * @author ������
 * 
 */
public class ProductPriceSO extends AbsBaseOrderSO {
	private static final long serialVersionUID = -1781692946414395461L;
	private StateType ask;// ����ȷ��
	private AskStyle style;// ���۷�ʽ

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
