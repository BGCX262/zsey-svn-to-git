package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * 部门
 * 
 * @author 杜永生
 * 
 */
public class AreaSO extends SOSupport {
	private static final long serialVersionUID = -5438746922350586004L;
	private String code;// 编号
	private String name;// 名称
	private Area area;// 所属地区

	public AreaSO() {
		super();
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	

}
