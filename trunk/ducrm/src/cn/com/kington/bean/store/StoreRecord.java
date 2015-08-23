package cn.com.kington.bean.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.OrderState;

/**
 * ����¼
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "xm_store_record")
public class StoreRecord extends EntitySupport {
	private static final long serialVersionUID = -3930920787419347133L;
	@Column(nullable = false)
	private Long storeId;// �ֿ�ID
	@Column(nullable = false, length = 50)
	private String storeName;// �ֿ�����
	@Column(nullable = false)
	private Long addId;// ������ID
	@Column(nullable = false, length = 50)
	private String addName;// ������
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private OrderState sort;// ����
	@Column(nullable = false, length = 50)
	private String name;// ����
	@Column(nullable = false, scale = 2, precision = 12)
	private Double amount;// ����

	public StoreRecord() {
		super();
	}

	public StoreRecord(Long storeId, String storeName, Long addId,
			String addName, OrderState sort, String name, Double amount) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.addId = addId;
		this.addName = addName;
		this.sort = sort;
		this.name = name;
		this.amount = amount;
	}



	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public OrderState getSort() {
		return sort;
	}

	public void setSort(OrderState sort) {
		this.sort = sort;
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


	public Long getAddId() {
		return addId;
	}


	public void setAddId(Long addId) {
		this.addId = addId;
	}


	public String getAddName() {
		return addName;
	}


	public void setAddName(String addName) {
		this.addName = addName;
	}

}