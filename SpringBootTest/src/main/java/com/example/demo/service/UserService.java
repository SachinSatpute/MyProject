package com.example.demo.service;
import java.util.*;
import com.example.demo.model.User;
public interface UserService {
	public List<User> getAllUser();
	public User getUserByName(String u);
	public User saveuser(User user);
}

