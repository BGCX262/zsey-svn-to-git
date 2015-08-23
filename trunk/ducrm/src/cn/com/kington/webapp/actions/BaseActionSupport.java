package cn.com.kington.webapp.actions;

import cc.mzone.struts2.coc.CocActionSupport;
import cn.com.kington.common.PageList;
import cn.com.kington.common.SOSupport;

public class BaseActionSupport extends CocActionSupport {
	private static final long serialVersionUID = 5418146919721144764L;
	protected int page;
	protected PageList<?> pageList;
	protected SOSupport bso;
	protected Long id;
	protected Long[] ids;

	public BaseActionSupport() {
		super();
		page = 1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageList<?> getPageList() {
		return pageList;
	}

	public void setPageList(PageList<?> pageList) {
		this.pageList = pageList;
	}

	public SOSupport getBso() {
		return bso;
	}

	public void setBso(SOSupport bso) {
		this.bso = bso;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
}
