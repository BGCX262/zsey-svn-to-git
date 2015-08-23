package cn.com.kington.bean.store;

import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.common.SOSupport;

/**
 * 库存
 * 
 * @author 杜永生
 * 
 */
public class StorageSO extends SOSupport {
	private static final long serialVersionUID = -2452117106808624356L;
	private Long storeId;// 所属仓库
	private Sort sort;// 库存类型
	private Long dataId;// 记录ID
	private String name;// 名称
	private String size;// 码数，当属性sort的属性值 为Sort.PRODUCT才需要填写
	private Double amount;// 数量
	private Double up;// 上限数量
	private Double down;// 下限数量
	private StateType state;// 盘点状态

	public StorageSO() {
		super();
	}

	public StorageSO(Long storeId, Sort sort, Long dataId, String size) {
		super();
		this.storeId = storeId;
		this.sort = sort;
		this.dataId = dataId;
		this.size = size;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getUp() {
		return up;
	}

	public void setUp(Double up) {
		this.up = up;
	}

	public Double getDown() {
		return down;
	}

	public void setDown(Double down) {
		this.down = down;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

}
