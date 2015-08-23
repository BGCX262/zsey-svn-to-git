package cn.com.kington.bean.produce;

import cn.com.kington.common.SOSupport;

/**
 * ��Ʒ����
 * 
 * @author ������
 * 
 */
public class ProductMaterialSO extends SOSupport {
	private static final long serialVersionUID = -3316839315024658248L;
	private Long proId;// ��ƷID
	private Long mateId;// ����ID
	private String code;// ���ϱ��
	private String name;// �������Ƽ����
	private Double amount;// ����
	private Double price;// �۸�
	private Double total;// ���
	private String unit;// ��λ

	public ProductMaterialSO() {
		super();
	}

	public ProductMaterialSO(Long proId, Long mateId, String code, String name,
			Double amount, Double price, Double total, String unit) {
		super();
		this.proId = proId;
		this.mateId = mateId;
		this.code = code;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.total = total;
		this.unit = unit;
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public Long getMateId() {
		return mateId;
	}

	public void setMateId(Long mateId) {
		this.mateId = mateId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
