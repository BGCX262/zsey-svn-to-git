package cn.com.kington.common;

import java.io.Serializable;

/**
 * 分布导航
 * @author 杜永生
 *
 */
public class Pagination implements Serializable {
	private static final long serialVersionUID = 0xda127cd0687b19aL;
	public static final int DEFAULT_PAGE_SIZE = 20;
	private int pageNumber;
	private int fullListSize;
	private int objectsPerPage;
	private int totalPages;

	public Pagination() {
		pageNumber = 1;
		objectsPerPage = 15;
		totalPages = -1;
	}

	public Pagination(Pagination page) {
		this();
		if (page == null) {
			return;
		}
		pageNumber = page.getPageNumber();
		fullListSize = page.getFullListSize();
		objectsPerPage = page.getObjectsPerPage();
		totalPages = page.getTotalPages();
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber <= 0) {
			return;
		} else {
			this.pageNumber = pageNumber;
			return;
		}
	}

	public int getFullListSize() {
		return fullListSize;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
		computeTotalPages();
	}

	public int getObjectsPerPage() {
		return objectsPerPage;
	}

	public void setObjectsPerPage(int objectsPerPage) {
		if (objectsPerPage <= 0) {
			return;
		} else {
			this.objectsPerPage = objectsPerPage;
			computeTotalPages();
			return;
		}
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void computeTotalPages() {
		totalPages = fullListSize / objectsPerPage;
		totalPages += fullListSize % objectsPerPage != 0 ? 1 : 0;
	}

	public int getStartIndex() {
		return (pageNumber - 1) * objectsPerPage;
	}

	public int getEndIndex() {
		return pageNumber * objectsPerPage;
	}
}

