package cn.com.kington.bean.buy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.store.AbsBaseOrder;
import cn.com.kington.common.PublicType.AskStyle;

/**
 * �ɹ������ϣ�ѯ��
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "xm_buy_price")
public class BuyPrice extends AbsBaseOrder {
	private static final long serialVersionUID = -3736919359269341799L;
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private AskStyle style;// ѯ�۷�ʽ

	public BuyPrice() {
		super();
	}

	public AskStyle getStyle() {
		return style;
	}

	public void setStyle(AskStyle style) {
		this.style = style;
	}

}
