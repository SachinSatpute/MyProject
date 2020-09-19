package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="USER")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@Column(name="firstname")
	String firstname;
	
	@Column(name="lastname")
	String lastname;
	
	@Column(name="email")
	String email;
	
	@Column(name="confirmpass")
	String confirmpass;
	
	@Column(name="birthdate")
	String birthdate;
	
	@Column(name="phonenumber")
	String phonenumber;
	
	@Column(name="gender")
	String gender;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname=lastname;
	}
	 
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;	
	}
	
	public String getConfirmpass() {
		return confirmpass;
	} 
	
	public void setConfirmpass(String confirmpass) {
		this.confirmpass=confirmpass;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate=birthdate;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber){
		this.phonenumber=phonenumber;
	}
	
	public String getGender(){
		return gender;
	}
	public void setGender(String gender) {
		this.gender=gender;
	}
}
