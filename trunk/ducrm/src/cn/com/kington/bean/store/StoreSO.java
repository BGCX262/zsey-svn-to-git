package cn.com.kington.bean.store;

import cn.com.kington.common.SOSupport;

/**
 * 仓库信息
 * 
 * @author 杜永生
 * 
 */
public class StoreSO extends SOSupport {
	private static final long serialVersionUID = 8427603500728421527L;
	private String name;// 名称

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
