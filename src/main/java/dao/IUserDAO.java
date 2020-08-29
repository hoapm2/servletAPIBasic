package dao;

import java.util.List;

import model.NewsModel;
import model.UserModel;
import paging.Pageable;

public interface IUserDAO extends GenericDao<UserModel>{
 UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
		
}
