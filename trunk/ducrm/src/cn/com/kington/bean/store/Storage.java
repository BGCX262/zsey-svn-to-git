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
 * ���
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_storage")
public class Storage extends EntitySupport {
	private static final long serialVersionUID = 1027565539450781102L;
	@Column(nullable = false)
	private Long storeId;// �����ֿ�ID
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private Sort sort;// �������
	@Column(nullable = false)
	private Long dataId;// ��¼ID
	@Column(nullable = false, length = 50)
	private String name;// ����
	@Column(length = 10)
	private String size;//������������sort������ֵ ΪSort.PRODUCT����Ҫ��д
	@Column(nullable = false, scale = 2, precision = 12)
	private Double amount;// ����
	@Column(scale = 2, precision = 12)
	private Double up;// ��������
	@Column(scale = 2, precision = 12)
	private Double down;// ��������
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private StateType state;// �̵�״̬

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