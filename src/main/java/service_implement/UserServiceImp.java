package service_implement;

import javax.inject.Inject;

import dao.IUserDAO;
import model.UserModel;
import service.IUserService;

public class UserServiceImp implements IUserService{

	@Inject
	private IUserDAO userDao;
	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
		
		return userDao.findByUsernameAndPasswordAndStatus(username, password, status);
	}

}
