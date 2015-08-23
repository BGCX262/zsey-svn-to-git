package cn.com.kington.bean.system;

import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.common.SOSupport;

/**
 * ÏµÍ³×Öµä¼ö
 * 
 * @author ¶ÅÓÀÉú
 * 
 */
public class SysDictSO extends SOSupport {
	private static final long serialVersionUID = -4206269299378994383L;
	private String code;
	private String name;
	private String caption;
	private Sort sort;

	public SysDictSO() {
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

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

}
