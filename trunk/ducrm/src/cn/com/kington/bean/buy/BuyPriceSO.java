package cn.com.kington.bean.buy;

import cn.com.kington.bean.store.AbsBaseOrderSO;
import cn.com.kington.common.PublicType.AskStyle;

/**
 * �ɹ������ϣ�ѯ��
 * 
 * @author ������
 * 
 */
public class BuyPriceSO extends AbsBaseOrderSO {
	private static final long serialVersionUID = -7007500497548803393L;
	private AskStyle style;// ѯ�۷�ʽ

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
