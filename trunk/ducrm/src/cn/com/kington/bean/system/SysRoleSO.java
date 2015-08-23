package cn.com.kington.bean.system;

import cn.com.kington.common.SOSupport;

/**
 * 系统角色查询对象
 * 
 * @author 杜永生
 * 
 */
public class SysRoleSO extends SOSupport {
	private static final long serialVersionUID = 1142679892390455182L;
	private String code;// 编号
	private String name;// 名称
	private String caption;// 备注

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
