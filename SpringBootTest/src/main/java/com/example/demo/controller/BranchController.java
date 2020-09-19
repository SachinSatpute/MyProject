package com.example.demo.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.model.Branch;
import com.example.demo.model.User;
import com.example.demo.service.BranchService;
import com.example.demo.service.BranchServiceImpl;

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

@Controller
public class BranchController {
	@Autowired
	BranchService branchservice;

	@RequestMapping(value="/BranchRegister",  method = RequestMethod.GET)
	public String branchRegister(ModelMap  model, @RequestParam("nsec")String nsec) {
		System.out.println("In user registration page");
		model.addAttribute("nsec", nsec);
		return "BranchRegistration";
	}
	
	
	@RequestMapping(value="/setBranch",  method = RequestMethod.POST)
	public ModelAndView setUser(ModelAndView modelandview, ModelMap  model, @RequestParam("branchname")String branchname, @RequestParam("nsec")String nsec, Branch branch) {
		System.out.println("In add Branch");
		System.out.println("Branch name is :" +branchname);
		Branch branch1 = branchservice.getBranchByName(branchname);
		if(branch1 != null){
			System.out.println("In Set User");
			model.put("brregistrationmsg", branchname + " Branch Already exist. Please Try with another branchname");
		}else {
			branch = branchservice.savebranch(branch);
			model.addAttribute("nsec", nsec);
			model.put("brregistrationmsg", branch.getBranchname() + " Branch Succssfully Created");
		}
		modelandview.setViewName("BranchRegistration");		
		return modelandview;
	}
	
	
}
