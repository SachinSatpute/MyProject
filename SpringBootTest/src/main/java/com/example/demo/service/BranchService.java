package com.example.demo.service;

import java.util.*;
import com.example.demo.model.Branch;
public interface BranchService {
	public List<Branch> getAllBranch();
	public Branch getBranchByName(String b);
	public Branch savebranch(Branch branch);
}
