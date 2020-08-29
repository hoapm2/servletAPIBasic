package dao;

import java.util.List;

import model.NewsModel;
import paging.Pageable;

public interface INewsDAO extends GenericDao<NewsModel>{
	List<NewsModel> findAddByCategoryID(Long categoryId);
	
	// ham add them bai viet moi, tra ve ID
	Long save(NewsModel news);
	void deleteNews(Long newsID);
	void updateNews(NewsModel updateNews);
	NewsModel findByID(Long id);
	int getTotalItems();
	List<NewsModel> findAll();
	List<NewsModel> findAll(Integer offset, Integer limit);
	List<NewsModel> findAll(Pageable pageable);
}
