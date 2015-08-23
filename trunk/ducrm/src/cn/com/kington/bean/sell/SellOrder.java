package cn.com.kington.bean.sell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.kington.bean.store.AbsBaseOrder;
import cn.com.kington.common.PublicType.OrderGrade;
import cn.com.kington.common.PublicType.OrderSort;
import cn.com.kington.common.PublicType.StateType;

/**
 * ���۶�������Ŀ��
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "xm_sell_order")
public class SellOrder extends AbsBaseOrder {
	private static final long serialVersionUID = -4398281966063555486L;
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private OrderGrade grade;// ������
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private OrderSort sort;// ��������
	@Column(length = 10)
	private String deliver;// ��������
	@Column(length = 12)
	@Enumerated(EnumType.STRING)
	private StateType make;// ����״̬

	public SellOrder() {
		super();
	}

	public OrderGrade getGrade() {
		return grade;
	}

	public void setGrade(OrderGrade grade) {
		this.grade = grade;
	}

	public OrderSort getSort() {
		return sort;
	}

	public void setSort(OrderSort sort) {
		this.sort = sort;
	}

	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public StateType getMake() {
		return make;
	}

	public void setMake(StateType make) {
		this.make = make;
	}

}
