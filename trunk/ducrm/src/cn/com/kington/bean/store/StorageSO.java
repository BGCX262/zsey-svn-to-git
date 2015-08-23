package cn.com.kington.bean.store;

import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.common.SOSupport;

/**
 * ���
 * 
 * @author ������
 * 
 */
public class StorageSO extends SOSupport {
	private static final long serialVersionUID = -2452117106808624356L;
	private Long storeId;// �����ֿ�
	private Sort sort;// �������
	private Long dataId;// ��¼ID
	private String name;// ����
	private String size;// ������������sort������ֵ ΪSort.PRODUCT����Ҫ��д
	private Double amount;// ����
	private Double up;// ��������
	private Double down;// ��������
	private StateType state;// �̵�״̬

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
