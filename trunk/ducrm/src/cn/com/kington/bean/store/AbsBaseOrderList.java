package cn.com.kington.bean.store;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import cn.com.kington.bean.EntitySupport;

/**
 * ��ϸ����
 * 
 * @author ������
 * 
 */
@MappedSuperclass
public abstract class AbsBaseOrderList extends EntitySupport {
	private static final long serialVersionUID = 5536583259653723433L;
	private Long proId;// ��ƷID
	@Column(length = 10)
	private String code;// ��Ʒ���
	@Column(nullable = false, length = 50)
	private String name;// ��Ʒ����
	@Column(nullable = false, length = 10)
	private String size;// ����
	@Column(length = 10)
	private String unit;// ��λ
	@Column(scale = 2, precision = 8)
	private Double price;// ��Ʒ����
	@Column(scale = 2, precision = 8)
	private Double amount;// ����
	@Column(scale = 2, precision = 8)
	private Double total;// ���
	@Column(length = 50)
	private String remark;// ������ע

	public AbsBaseOrderList() {
		super();
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
