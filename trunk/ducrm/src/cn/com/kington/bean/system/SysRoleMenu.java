package cn.com.kington.bean.system;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import cn.com.kington.bean.EntitySupport;

/**
 * 系统角色授权
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "sys_role_menu", uniqueConstraints = @UniqueConstraint(columnNames = {"fk_role_id", "fk_menu_id" }))
public class SysRoleMenu extends EntitySupport {
	private static final long serialVersionUID = -3479038844464495188L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_role_id")
	private SysRole role;// 所属系统角色
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_menu_id")
	private SysMenu menu;// 所属功能菜单

	public SysRoleMenu() {
		super();
	}

	public SysRoleMenu(SysRole role, SysMenu menu) {
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
