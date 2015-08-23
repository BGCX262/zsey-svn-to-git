package cn.com.kington.bean.system;

import cn.com.kington.common.SOSupport;

/**
 * 系统角色授权
 * 
 * @author 杜永生
 * 
 */
public class SysRoleMenuSO extends SOSupport {
	private static final long serialVersionUID = 5185871718789529313L;
	private SysRole role;// 所属系统角色
	private SysMenu menu;// 所属功能菜单

	public SysRoleMenuSO() {
		super();
	}

	public SysRoleMenuSO(SysRole role, SysMenu menu) {
		super();
		this.role = role;
		this.menu = menu;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public SysMenu getMenu() {
		return menu;
	}

	public void setMenu(SysMenu menu) {
		this.menu = menu;
	}

}
