package com.example.demo.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController
//@EnableAutoConfiguration
@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
    //@ResponseBody
	@RequestMapping(value="/Backtohome",  method = RequestMethod.GET)
	public String home(ModelMap  model, @RequestParam("nsec")String nsec) {
		System.out.println("In Back to home");
		model.addAttribute("nsec", nsec);
		System.out.println("In Back to home nsec is"+nsec);
		return "home";
	}
	
	@RequestMapping(value="/login",  method = RequestMethod.GET)
	public String login() {
		System.out.println("In admin login page");
		return "login";
	}
	
	@RequestMapping(value="/UserRegister",  method = RequestMethod.GET)
	public String userRegister(ModelMap  model, @RequestParam("nsec")String nsec) {
		System.out.println("In user registration page");
		model.addAttribute("nsec", nsec);
		return "UserRegistration";
	}
	
	@RequestMapping(value="/getUser",  method = RequestMethod.GET)
	public ModelAndView getUser(ModelAndView modelandview, ModelMap  model, @RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("nsec")String nsec, HttpServletRequest request, HttpSession session) {
		System.out.println("login uname "+username);
		System.out.println("login pass "+password);
		System.out.println("nsec is :"+nsec);
		List<User> listOfUsers = userservice.getAllUser();
		User user = userservice.getUserByName(username);
		
		String userlogin = (String)request.getSession().getAttribute(nsec+"himsg");
		if(userlogin != null) {
			model.put("loginerrmsg", "User Already Login On Another Tab. Logout Please");
			modelandview.setViewName("index");
			return modelandview;
		}
		
		if(user == null) {
			model.put("loginerrmsg", "USERNAME OR PASSWORD ARE INVALID");
			modelandview.setViewName("index");
			return modelandview;
		}
		if(!password.equals(user.getPassword())) {
			model.put("loginerrmsg", "USERNAME OR PASSWORD ARE INVALID");
			System.out.println("database uname is"+user.getUsername());
			System.out.println("database pass is"+user.getPassword());
			modelandview.setViewName("index");
		}else {
			request.getSession().setAttribute(nsec+"himsg", user.getUsername());
			//session.setAttribute(nsec+"himsg", username);
			model.addAttribute("nsec", nsec);
			model.addAttribute("user", new User());
			model.addAttribute("listOfUser", listOfUsers);
			//model.put("himsg", user.getUsername());
			modelandview.setViewName("home");
		}	
		return modelandview;
		//return "home";
	}
	
	@RequestMapping(value="/setUser",  method = RequestMethod.POST)
	public ModelAndView setUser(ModelAndView modelandview, ModelMap  model, @RequestParam("username")String username, @RequestParam("nsec")String nsec, User user) {
		System.out.println("In add user");
		User user1 = userservice.getUserByName(username);
		if(user1 != null){
			System.out.println("In Set User");
			model.put("registrationmsg", username + " User Already exist. Please Try with another username");
		}else {
			System.out.println("Gender is" +user.getGender());
			user = userservice.saveuser(user);
			model.addAttribute("nsec", nsec);
			model.put("registrationmsg", user.getUsername() + " User Succssfully Created");
		}
		modelandview.setViewName("UserRegistration");		
		return modelandview;
	}
	
	
	
//	 @RequestMapping(value="/setUser1",method=RequestMethod.POST)
//	 public @ResponseBody String addUser(@ModelAttribute(value="user") @RequestParam("username")String username, User user, BindingResult result ){
//		 String returnText;
//	 	 User user1 = userservice.getUserByName(username);
//	 	 if(!result.hasErrors()){
//	 	   		user = userservice.saveuser(user);
//	 	        returnText = "User has been added Succsesfully.";
//	 	 }else{
//	 	        returnText = "Sorry, an error has occur. User has not been added.";
//	  	 }
//	 	 return returnText;
//	 }
	
}
