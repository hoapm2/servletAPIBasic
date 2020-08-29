package service_implement;

import java.util.List;

import javax.inject.Inject;

import dao.ICategoryDAO;
import dao_implement.CategoryDAO;
import model.CategoryModel;
import model.NewsModel;
import service.ICategoryService;

public class CategoryServiceImp  implements ICategoryService{

	@Inject  
	private ICategoryDAO categogyDao;
	@Override 
	public List<CategoryModel> findAll() {
		return categogyDao.findAll();
	}
	@Override
	public List<NewsModel> findNewsbyCategoryID(Long categoryid) {
		return categogyDao.findByCategoryId(categoryid);
		
	}
	
	
//   cach nha que
//	private ICategoryDAO categoryDao;
//	
//    public CategoryServiceImp() {
//    	categoryDao = new CategoryDAO();
//	} 
//
//
//	@Override
//	public List<CategoryModel> findAll() {
//		return categoryDao.findAll();
//	}
		
		
} 
