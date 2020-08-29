package service;

import java.util.List;

import model.NewsModel;
import paging.Pageable;

public interface INewsService {
	 List<NewsModel> findAllByCategoryId(Long categoryId);
	 NewsModel save(NewsModel news);
	 void delete(long[] ids);
	 NewsModel update(NewsModel updateNews);
	 NewsModel searchbyID(Long id);
	 List<NewsModel> findAll();
	 List<NewsModel> findAll(Integer offset, Integer limit);
	 List<NewsModel> findAll(Pageable pageable);
	 int getTotalItems();
}
