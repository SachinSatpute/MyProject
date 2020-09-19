package com.example.demo.service;

import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userepository;
	public List<User> getAllUser() {
		List<User>  userList = userepository.findAll();
		return userList;
	}
	
	public User getUserByName(String u) {
		User  user = userepository.findByUsername(u);
		return user;
	}
	
	public User saveuser(User u) {
		User  user = userepository.save(u);
		return user;
	}
}
