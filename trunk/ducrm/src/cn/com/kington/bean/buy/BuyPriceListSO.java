package cn.com.kington.bean.buy;

import cn.com.kington.common.SOSupport;

/**
 * ���۶�������Ŀ��������ϸ
 * 
 * @author ������
 * 
 */
public class BuyPriceListSO extends SOSupport {
	private static final long serialVersionUID = -9073808638500177472L;
	private BuyPrice order;// �������۵�
	private Long mateId;// ����ID
	private String name;// ����
	private String spec;// ���
	private String unit;// ��λ
	private Double amount;// ����
	private Double price;// ����
	private String remark;// ��ע

	public BuyPriceListSO() {
		super();
	}

	public BuyPrice getOrder() {
		return order;
	}

	public void setOrder(BuyPrice order) {
		this.order = order;
	}

	public Long getMateId() {
		return mateId;
	}

	public void setMateId(Long mateId) {
		this.mateId = mateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
