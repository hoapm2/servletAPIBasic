package service_implement;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import dao.ICategoryDAO;
import dao.INewsDAO;
import model.CategoryModel;
import model.NewsModel;
import paging.Pageable;
import service.INewsService;

public class NewsServiceImp implements INewsService {
	@Inject
	private INewsDAO newsDao;
	
	@Inject
	private ICategoryDAO categoryDao;
	
	
	
@Override
public List<NewsModel> findAllByCategoryId(Long categoryId) {
	return newsDao.findAddByCategoryID(categoryId);
}

@Override
public NewsModel save(NewsModel news) {
	news.setCreateDate(new Timestamp(System.currentTimeMillis()));
	CategoryModel categoryModel= categoryDao.findOneByCode(news.getCategoryCode());
	news.setCategoryId(categoryModel.getId());
	news.setCreateBy("");
	Long id=newsDao.save(news);
	return newsDao.findByID(id);
}

@Override
public void delete(long [] ids) {
	for (long id: ids) {
		newsDao.deleteNews(id);
	}
	
}



@Override
public NewsModel searchbyID(Long id) {
	NewsModel newsModel = newsDao.findByID(id);
	CategoryModel categoryModel= categoryDao.findOne(newsModel.getCategoryId());
	newsModel.setCategoryCode(categoryModel.getCode());
	return newsModel;
}

@Override
public NewsModel update(NewsModel updateNews) {
	NewsModel old=newsDao.findByID(updateNews.getId());
	// lay nhung thong tin ko co tu UI: ngay tao va nguoi tao: lay tu cai news cu -> update sang news moi
	updateNews.setCreateDate(old.getCreateDate());
	updateNews.setCreateBy(old.getCreateBy());
	// ngay sua, nguoi sua, khi nao cap nhat tren UI thi phai update lai
	updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
	CategoryModel categoryModel= categoryDao.findOneByCode(updateNews.getCategoryCode());
	updateNews.setCategoryId(categoryModel.getId());
	updateNews.setModifiedBy("");
     newsDao.updateNews(updateNews);
     return newsDao.findByID(updateNews.getId());
}
@Override
public List<NewsModel> findAll() {
	
	return newsDao.findAll();
}
@Override
public List<NewsModel> findAll(Integer offset, Integer limit) {
	return newsDao.findAll(offset, limit);
}

@Override
public int getTotalItems() {
	return newsDao.getTotalItems();
}

@Override
public List<NewsModel> findAll(Pageable pageable) {
	return newsDao.findAll(pageable);
}




}
 