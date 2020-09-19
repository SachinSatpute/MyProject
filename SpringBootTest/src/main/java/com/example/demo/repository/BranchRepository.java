package com.example.demo.repository;
import com.example.demo.model.Branch;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch, Long> {

	List<Branch> findAll();	
	Branch findByBranchname(String b);	
	Branch save(Branch branch);
}
