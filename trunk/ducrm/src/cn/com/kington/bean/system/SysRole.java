package cn.com.kington.bean.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * ϵͳ��ɫ
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "sys_role")
public class SysRole extends EntitySupport {
	private static final long serialVersionUID = -4897740336272221333L;
	@Column(name = "code", nullable = false, unique = true)
	private String code;// ���
	@Column(nullable = false)
	private String name;// ����
	private String caption;// ��ע

	public SysRole() {
		super();
	}

	public SysRole(String code, String name, String caption) {
		super();
		this.code = code;
		this.name = name;
		this.caption = caption;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

}
