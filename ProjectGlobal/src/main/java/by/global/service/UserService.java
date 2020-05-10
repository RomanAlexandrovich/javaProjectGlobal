package by.global.service;

import java.util.List;

import by.global.model.UserMY;

public interface UserService {
	 void save(UserMY user, boolean level);

	    UserMY findByUsername(String username);
	    List<UserMY> findAllUser();
	    

}
