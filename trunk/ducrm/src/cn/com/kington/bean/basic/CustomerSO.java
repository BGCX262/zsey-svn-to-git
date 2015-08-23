package cn.com.kington.bean.basic;

import cn.com.kington.bean.system.SysDict;


/**
 * 客户信息
 * 
 * @author 杜永生
 * 
 */
public class CustomerSO extends AbsBaseClientSO {
	private static final long serialVersionUID = 97948349424654893L;
	private SysDict sort;// 客户类型

	public CustomerSO() {
		super();
	}

	public SysDict getSort() {
		return sort;
	}

	public void setSort(SysDict sort) {
		this.sort = sort;
	}

}
