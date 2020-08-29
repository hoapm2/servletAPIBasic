package dao;

import java.util.List;

import model.CategoryModel;
import model.NewsModel;

public interface ICategoryDAO extends GenericDao<CategoryModel> {
	List<CategoryModel> findAll();
	List<NewsModel> findByCategoryId(Long categoryId); 
	CategoryModel findOne(long id);
	CategoryModel findOneByCode(String code);
}
