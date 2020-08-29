package service;

import java.util.List;

import model.CategoryModel;
import model.NewsModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	List<NewsModel>findNewsbyCategoryID(Long categoryid);
}
