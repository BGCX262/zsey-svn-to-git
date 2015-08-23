package cn.com.kington.bean.system;

import cn.com.kington.common.SOSupport;

/**
 * 系统角色用户
 * 
 * @author 杜永生
 * 
 */
public class SysRoleUserSO extends SOSupport {
	private static final long serialVersionUID = 8124811090533398567L;
	private SysRole role;// 所属系统角色
	private SysUser user;// 所属系统用户

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
