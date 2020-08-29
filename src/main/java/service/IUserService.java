package service;

import model.UserModel;

public interface IUserService {
	UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
}
