package cn.com.kington.common;

import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

public class PageList<T> extends Pagination implements PaginatedList {
	private static final long serialVersionUID = 695625161507023876L;
	private  List<?> list;
	
	public PageList() {
	}

	public PageList(Pagination page) {
		super(page);
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public List<?> getList() {
		return list;
	}

	public String getSearchId() {
		return null;
	}

	public String getSortCriterion() {
		return null;
	}

	public SortOrderEnum getSortDirection() {
		return null;
	}
}