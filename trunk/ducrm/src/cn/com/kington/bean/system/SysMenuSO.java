package cn.com.kington.bean.system;

import cn.com.kington.common.SOSupport;

/**
 * ϵͳ���ܲ˵�
 * 
 * @author ������
 * 
 */
public class SysMenuSO extends SOSupport {
	private static final long serialVersionUID = -6602958531859885070L;
	private String enName;// ���
	private String chName;// ����
	private String href;// ���ӵ�ַ
	private int sort;// ����
	private SysMenu parentMenu;

	public SysMenuSO() {
		super();
	}

	public SysMenuSO(String enName, String chName, SysMenu parentMenu) {
		super();
		this.enName = enName;
		this.chName = chName;
		this.parentMenu = parentMenu;
	}

	public SysMenuSO(String enName, String chName, String href, int sort,
			SysMenu parentMenu) {
		super();
		this.enName = enName;
		this.chName = chName;
		this.href = href;
		this.sort = sort;
		this.parentMenu = parentMenu;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public SysMenu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(SysMenu parentMenu) {
		this.parentMenu = parentMenu;
	}

}
