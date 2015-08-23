package cn.com.kington.bean.store;

import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.SOSupport;

/**
 * 库存记录
 * 
 * @author 杜永生
 * 
 */
public class StoreRecordSO extends SOSupport {
	private static final long serialVersionUID = -6431410453008846013L;
	private Long storeId;// 仓库ID
	private String storeName;// 仓库名称
	private Long addId;// 操作人ID
	private String addName;// 操作人
	private OrderState sort;// 类型
	private String name;// 名称
	private Double amount;// 数量

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