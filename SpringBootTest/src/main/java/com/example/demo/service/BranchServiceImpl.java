package com.example.demo.service;

import com.example.demo.service.BranchService;
import com.example.demo.repository.BranchRepository;
import com.example.demo.model.Branch;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {
	@Autowired
	BranchRepository branchrepository;
	public List<Branch> getAllBranch() {
		List<Branch>  branchList = branchrepository.findAll();
		return branchList;
	}
	
	public Branch getBranchByName(String b) {
		Branch  branch = branchrepository.findByBranchname(b);
		return branch;
	}
	
	public Branch savebranch(Branch b) {
		Branch  branch = branchrepository.save(b);
		return branch;
	}
}
