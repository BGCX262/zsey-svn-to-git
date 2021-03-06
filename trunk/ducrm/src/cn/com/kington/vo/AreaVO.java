package cn.com.kington.vo;

import java.io.Serializable;

/**
 * 地区前台视图展示业务BEAN
 * @author 杜永生
 *
 */
public class AreaVO implements Serializable {
	private static final long serialVersionUID = 5086403735241150082L;
	private Long id;
	private String code;
	private String name;

	public AreaVO() {
		super();
	}

	public AreaVO(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
