 package dao;

import java.util.List;

import maper.RowMaper;

public interface GenericDao<T> {
	 <T> List<T> query(String sql, RowMaper<T> rowMaper , Object...parameters);
	 Long insert(String sql, Object...parameters);
	 void update(String sql, Object...parameters);
	 void delete (String sql, Object...parameters);
	 int count(String sql,Object...parameters);
	 T ifindByID(String sql, RowMaper<T>rowMaper, Object...parameters);
	/*
	 * <T> List<T> query2(String sql, RowMaper<T> rowMaper , Object...parameters);
	 * void update2(String sql, Object...parameters); T findbyID(String sql,
	 * RowMaper<T> rowMaper, Object...parameters);
	 */
}
