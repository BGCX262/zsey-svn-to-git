package cn.com.kington.bean.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.Sort;

/**
 * ÏµÍ³×Öµä¼ö
 * 
 * @author ¶ÅÓÀÉú
 * 
 */
@Entity
@Table(name = "sys_dict", uniqueConstraints = @UniqueConstraint(columnNames = {"code", "sort" }))
public class SysDict extends EntitySupport {
	private static final long serialVersionUID = 5398188703361898868L;
	@Column(nullable = false, length = 4)
	private String code;
	@Column(nullable = false, length = 30)
	private String name;
	@Column(length = 50)
	private String caption;
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Sort sort;

	public SysDict() {
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
