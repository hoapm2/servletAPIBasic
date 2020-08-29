package paging;

import sort.SortImplement;

public interface Pageable {
	Integer getpage();
	Integer getOffset();
	Integer getLimit();
	SortImplement getSortImplement();
}
