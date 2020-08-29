package maper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.NewsModel;
import model.RoleModel;
import model.UserModel;

public class UserMaper implements RowMaper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {

		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			user.setFullName(resultSet.getString("fullname"));
			try {// phong khi chi query moi user, ko join vs bang role.
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return user;
		}

		catch (SQLException e) {

			return null;
		}

	}
}
