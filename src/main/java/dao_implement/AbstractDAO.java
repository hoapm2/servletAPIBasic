package dao_implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import dao.GenericDao;
import maper.RowMaper;
import model.NewsModel;
import model.UserModel;

public class AbstractDAO<T> implements GenericDao<T> {
	
	ResourceBundle resourceBundle= ResourceBundle.getBundle("db"); // tranh viec hashcode java
	
	public Connection getConnection() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/testsql";
//			String user = "root";
//			String password = "hoa123456";
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user =  resourceBundle.getString("user");
			String password =  resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMaper<T> rowMaper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			prepareStatement = connection.prepareStatement(sql);
			// set Parameter:
			setParameter(prepareStatement, parameters);
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				results.add(rowMaper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}

	private void setParameter(PreparedStatement prepareStatement, Object... parameters) {
		try {
			int k = parameters.length;
			for (int i = 0; i < k; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					prepareStatement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					prepareStatement.setString(index, (String) parameter);
				} else if (parameter instanceof Timestamp) {
					prepareStatement.setTimestamp(index, (Timestamp) parameter);
				} else if (parameter == null) {
					prepareStatement.setNull(index, Types.NULL);
				} else if (parameter instanceof Integer) {
					prepareStatement.setInt(index, (Integer) parameter);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void setParameter2(PreparedStatement preparedStatement, Object...parameters) {
		try {
			int k=parameters.length;
			for (int i=0; i<k; i++) {
				int index=i+1;
				Object parameter=parameters[i];
				if (parameter instanceof Long) {
					preparedStatement.setLong(index, (Long) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Long id = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			rs = preparedStatement.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				System.out.println(e.getMessage());
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
	}


	@Override
	public void delete(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}

	}

	@Override
	public T ifindByID(String sql, RowMaper<T> rowMaper, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		T t = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				t = rowMaper.mapRow(rs);
			}
			return t;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			int count = 0;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}

	}

}
