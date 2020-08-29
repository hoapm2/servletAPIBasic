package paging;

import sort.SortImplement;

public class PageRequest implements Pageable {

	private Integer page;
	private Integer maxItemOnPage;
	private SortImplement sortImplement;

	public PageRequest(Integer page, Integer maxItemOnPage, SortImplement sortImplement) {
		this.page = page;
		this.maxItemOnPage = maxItemOnPage;
		this.setSortImplement(sortImplement);
	}

	@Override
	public Integer getpage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if (this.page!=null && this.maxItemOnPage!=null) {
			return (this.page - 1) * this.maxItemOnPage;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxItemOnPage;
	}

	public SortImplement getSortImplement() {
			if (this.sortImplement!=null) {
				return this.sortImplement;
			}
			return null;
	}

	public void setSortImplement(SortImplement sortImplement) {
		this.sortImplement = sortImplement;
	}

}
