package cn.com.kington.bean.system;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import cn.com.kington.bean.EntitySupport;

/**
 * ϵͳ��ɫ�û�
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "sys_role_user", uniqueConstraints = @UniqueConstraint(columnNames = {"fk_role_id", "fk_user_id" }))
public class SysRoleUser extends EntitySupport {
	private static final long serialVersionUID = 8450617431308278229L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_role_id")
	private SysRole role;// ����ϵͳ��ɫ
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user_id")
	private SysUser user;// ����ϵͳ�û�

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
