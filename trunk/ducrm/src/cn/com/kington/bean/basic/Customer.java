package cn.com.kington.bean.basic;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.system.SysDict;

/**
 * 客户信息
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "base_customer")
public class Customer extends AbsBaseClient {
	private static final long serialVersionUID = 7429917374080133996L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_sort_id")
	private SysDict sort;// 客户类型

	public Customer() {
		super();
	}

	public SysDict getSort() {
		return sort;
	}

	public void setSort(SysDict sort) {
		this.sort = sort;
	}

}
