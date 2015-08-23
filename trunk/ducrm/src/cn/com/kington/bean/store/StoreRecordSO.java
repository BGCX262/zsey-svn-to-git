package cn.com.kington.bean.store;

import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.SOSupport;

/**
 * ����¼
 * 
 * @author ������
 * 
 */
public class StoreRecordSO extends SOSupport {
	private static final long serialVersionUID = -6431410453008846013L;
	private Long storeId;// �ֿ�ID
	private String storeName;// �ֿ�����
	private Long addId;// ������ID
	private String addName;// ������
	private OrderState sort;// ����
	private String name;// ����
	private Double amount;// ����

	public StoreRecordSO() {
		super();
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