package cn.com.kington.bean.system;

import cn.com.kington.common.SOSupport;

/**
 * ϵͳ��ɫ�û�
 * 
 * @author ������
 * 
 */
public class SysRoleUserSO extends SOSupport {
	private static final long serialVersionUID = 8124811090533398567L;
	private SysRole role;// ����ϵͳ��ɫ
	private SysUser user;// ����ϵͳ�û�

	public SysRoleUserSO() {
		super();
	}

	public SysRoleUserSO(SysRole role, SysUser user) {
		super();
		this.role = role;
		this.user = user;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

}
