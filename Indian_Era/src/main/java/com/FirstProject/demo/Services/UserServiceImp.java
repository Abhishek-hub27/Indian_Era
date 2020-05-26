package com.FirstProject.demo.Services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.FirstProject.demo.Model.Role;
import com.FirstProject.demo.Model.User;
import com.FirstProject.demo.Repository.RoleRepository;
import com.FirstProject.demo.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
	   
       user.setPassword(encoder.encode(user.getPassword()));
       user.setStatus("VERIFIED");
       Role userRole =roleRepository.findByRole("SITE_USER");
       user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
       userRepository.save(user);
	}

	@Override
	public boolean isUserAlreadyPresent(User user) {
		boolean isUserAlreadyExists = false;
		User existingUser = userRepository.findByEmail(user.getEmail());
		// If user is found in database, then then user already exists.
		if(existingUser != null){
			isUserAlreadyExists = true; 
		}
		return isUserAlreadyExists;
	}

}
