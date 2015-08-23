package cn.com.kington.bean.system;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import cn.com.kington.bean.EntitySupport;

/**
 * 系统角色用户
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "sys_role_user", uniqueConstraints = @UniqueConstraint(columnNames = {"fk_role_id", "fk_user_id" }))
public class SysRoleUser extends EntitySupport {
	private static final long serialVersionUID = 8450617431308278229L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_role_id")
	private SysRole role;// 所属系统角色
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user_id")
	private SysUser user;// 所属系统用户

	public SysRoleUser() {
		super();
	}

	public SysRoleUser(SysRole role, SysUser user) {
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
