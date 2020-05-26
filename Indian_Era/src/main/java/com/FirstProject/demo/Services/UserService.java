package com.FirstProject.demo.Services;

import com.FirstProject.demo.Model.User;

public interface UserService {

	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);
}
