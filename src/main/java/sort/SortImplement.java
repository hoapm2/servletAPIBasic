package sort;

public class SortImplement implements Sortable {
	private String sortName;
	private String sortBy;

	public SortImplement(String sortName, String sortBy) {
		this.setSortBy(sortBy);
		this.setSortName(sortName);
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
}
