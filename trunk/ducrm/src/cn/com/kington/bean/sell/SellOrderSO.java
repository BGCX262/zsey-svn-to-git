package cn.com.kington.bean.sell;

import cn.com.kington.bean.store.AbsBaseOrderSO;
import cn.com.kington.common.PublicType.OrderGrade;
import cn.com.kington.common.PublicType.OrderSort;
import cn.com.kington.common.PublicType.StateType;

/**
 * 销售项目订单
 * 
 * @author 杜永生
 * 
 */
public class SellOrderSO extends AbsBaseOrderSO {
	private static final long serialVersionUID = -6633368387644427917L;
	private OrderGrade grade;// 紧急度
	private OrderSort sort;// 订单类型
	private String deliver;// 交货日期
	private StateType make;// 生产状态

	public SellOrderSO() {
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
