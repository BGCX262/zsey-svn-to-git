package cn.com.kington.bean.system;

import cn.com.kington.common.SOSupport;

/**
 * ϵͳ��ɫ��ѯ����
 * 
 * @author ������
 * 
 */
public class SysRoleSO extends SOSupport {
	private static final long serialVersionUID = 1142679892390455182L;
	private String code;// ���
	private String name;// ����
	private String caption;// ��ע

	public SysRoleSO() {
		super();
	}

	public SysRoleSO(String code, String name, String caption) {
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
