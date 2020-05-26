package com.FirstProject.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FirstProject.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User ,Integer>{

	public User findByEmail(String email);
}
