package cn.com.kington.bean.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * 系统功能菜单
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "sys_menu")
public class SysMenu extends EntitySupport {
	private static final long serialVersionUID = 5353274719791839084L;
	@Column(name = "enName", nullable = false, unique = true)
	private String enName;// 编号
	@Column(nullable = false)
	private String chName;// 名称
	private String href;// 链接地址
	private int sort;// 排序
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	private SysMenu parentMenu;

	public SysMenu() {
		super();
	}

	public SysMenu(String enName, String chName, String href, int sort,
			SysMenu parentMenu) {
		super();
		this.enName = enName;
		this.chName = chName;
		this.href = href;
		this.sort = sort;
		this.parentMenu = parentMenu;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public SysMenu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(SysMenu parentMenu) {
		this.parentMenu = parentMenu;
	}

}
