package maper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.NewsModel;

public class NewsMaper implements RowMaper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		
		try {
			NewsModel news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortDescription"));
			news.setCreateDate(resultSet.getTimestamp("createdDate"));
			news.setCreateBy(resultSet.getString("createBy"));
			if (resultSet.getTimestamp("modifiedDate")!=null) {
				news.setModifiedDate(resultSet.getTimestamp("modifiedDate"));
			}
			if (resultSet.getString("modifiedBy")!=null) {
				news.setModifiedBy(resultSet.getString("modifiedBy"));
			}
			return news;
		} catch (SQLException e) {

			return null;
		}

	}
}
