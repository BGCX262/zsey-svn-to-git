package cn.com.kington.bean.system;

import cn.com.kington.common.SOSupport;

/**
 * ϵͳ��ɫ��Ȩ
 * 
 * @author ������
 * 
 */
public class SysRoleMenuSO extends SOSupport {
	private static final long serialVersionUID = 5185871718789529313L;
	private SysRole role;// ����ϵͳ��ɫ
	private SysMenu menu;// �������ܲ˵�

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
