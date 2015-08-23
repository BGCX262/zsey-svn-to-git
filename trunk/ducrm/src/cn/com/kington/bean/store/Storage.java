package cn.com.kington.bean.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.common.PublicType.StateType;

/**
 * 库存
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "base_storage")
public class Storage extends EntitySupport {
	private static final long serialVersionUID = 1027565539450781102L;
	@Column(nullable = false)
	private Long storeId;// 所属仓库ID
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private Sort sort;// 库存类型
	@Column(nullable = false)
	private Long dataId;// 记录ID
	@Column(nullable = false, length = 50)
	private String name;// 名称
	@Column(length = 10)
	private String size;//码数，当属性sort的属性值 为Sort.PRODUCT才需要填写
	@Column(nullable = false, scale = 2, precision = 12)
	private Double amount;// 数量
	@Column(scale = 2, precision = 12)
	private Double up;// 上限数量
	@Column(scale = 2, precision = 12)
	private Double down;// 下限数量
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private StateType state;// 盘点状态

	public Storage() {
		super();
	}

	public Storage(Long storeId, Sort sort, Long dataId, String size) {
		super();
		this.storeId = storeId;
		this.sort = sort;
		this.dataId = dataId;
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
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

}