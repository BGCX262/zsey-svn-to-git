package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * ����
 * 
 * @author ������
 * 
 */
public class AreaSO extends SOSupport {
	private static final long serialVersionUID = -5438746922350586004L;
	private String code;// ���
	private String name;// ����
	private Area area;// ��������

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
