package cn.com.kington.bean.store;

import cn.com.kington.common.SOSupport;

/**
 * �ֿ���Ϣ
 * 
 * @author ������
 * 
 */
public class StoreSO extends SOSupport {
	private static final long serialVersionUID = 8427603500728421527L;
	private String name;// ����

	public StoreSO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
