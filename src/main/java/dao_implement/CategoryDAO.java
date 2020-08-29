package dao_implement;



import java.util.List;

import dao.ICategoryDAO;
import maper.CategoryMaper;
import maper.NewsMaper;
import model.CategoryModel;
import model.NewsModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {


	

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
	    String sql="Select * from news where categoryid=?";
	    return query(sql, new NewsMaper(), categoryId);
	}

	@Override
	public List<CategoryModel> findAll() {
		String sql="SELECT * FROM Category";
		return query(sql, new CategoryMaper());
	}

	@Override
	public CategoryModel findOne(long id) {
		String sql="select * from category where id=?";
		List<CategoryModel> categories= query(sql, new CategoryMaper(), id);
		return categories.isEmpty()? null: categories.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql="select * from category where code=?";
		List<CategoryModel> categories= query(sql, new CategoryMaper(), code);
		return categories.isEmpty()? null: categories.get(0);
	}
	
}
