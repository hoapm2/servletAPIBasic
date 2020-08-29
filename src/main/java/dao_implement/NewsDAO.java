package dao_implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.mysql.cj.xdevapi.Statement;

import dao.INewsDAO;
import maper.NewsMaper;
import model.NewsModel;
import paging.Pageable;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	
	
	@Override
	public List<NewsModel> findAddByCategoryID(Long categoryId) {
		String sql = "select * from news where categoryid= ?";
		return query(sql, new NewsMaper(), categoryId);
	}



	

	@Override
	public Long save(NewsModel news) {
		String sql = "Insert into news (title, thumbnail,shortDescription, content,createdDate,modifiedDate,createBy,modifiedBy, categoryid) values (?,?,?,?,?,?,?,?,?)";
		return insert(sql, news.getTitle(),news.getThumbnail(),
				news.getShortDescription(),news.getContent(),news.getCreateDate(),
				news.getModifiedDate(),news.getCreateBy(),news.getModifiedBy(), news.getCategoryId());
	}



	@Override
	public void deleteNews(Long newsID) {
	   String sql="Delete from news where id=?";
	   delete(sql, newsID);
	}





	@Override
	public NewsModel findByID(Long id) {
		String sql="Select * from news where id=?";
		return ifindByID(sql, new NewsMaper(), id);
	}

	@Override
	public void updateNews(NewsModel updateNews) {
		String sql="update news set title=?, thumbnail=?, shortDescription=?, content=?, categoryid=?, createdDate=?, createBy=?, modifiedDate=?, modifiedBy=? where id=?";
		update(sql, updateNews.getTitle(), updateNews.getThumbnail(),updateNews.getShortDescription(), 
				updateNews.getContent(),updateNews.getCategoryId(),updateNews.getCreateDate() ,updateNews.getCreateBy(),
				updateNews.getModifiedDate(),updateNews.getModifiedBy(),updateNews.getId() );
	}



	@Override
	public int getTotalItems() {
		String sql="select Count(*) from news";
		return count(sql);
	}



	@Override
	public List<NewsModel> findAll() {
		String sql = "select * from news";
		return query(sql, new NewsMaper());
	}


	@Override
	public List<NewsModel> findAll(Integer offset, Integer limit) {
		String sql = "select * from news limit ?,?";
		return query(sql, new NewsMaper(),offset, limit);
	}





	@Override
	public List<NewsModel> findAll(Pageable pageable) {
		StringBuilder sql= new StringBuilder("Select * from news");
		if (pageable.getSortImplement()!=null) {
			sql.append(" order by "+pageable.getSortImplement().getSortName()+" "+ pageable.getSortImplement().getSortBy());
		} 
		if (pageable.getOffset()!=null & pageable.getLimit()!=null) {
			sql.append(" limit "+ pageable.getOffset()+" , "+pageable.getLimit());		
		}
		return query(sql.toString(), new NewsMaper());
			
	}







	

}
