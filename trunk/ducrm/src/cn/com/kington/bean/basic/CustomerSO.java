package cn.com.kington.bean.basic;

import cn.com.kington.bean.system.SysDict;


/**
 * �ͻ���Ϣ
 * 
 * @author ������
 * 
 */
public class CustomerSO extends AbsBaseClientSO {
	private static final long serialVersionUID = 97948349424654893L;
	private SysDict sort;// �ͻ�����

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
