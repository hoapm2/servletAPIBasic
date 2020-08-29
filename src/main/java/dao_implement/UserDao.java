package dao_implement;

import java.util.List;

import dao.IUserDAO;
import maper.UserMaper;
import model.RoleModel;
import model.UserModel;

public class UserDao extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
		String sql="select * from user "
				+ "inner join role on user.roleid=role.id where username =? and password =? and status=?";
		List<UserModel> users= query(sql, new UserMaper(), username,password,status);
		return users.isEmpty() ? null: users.get(0);
	}
	
}
