package com.model;

public class AdminTeacher {
	
	int teacher_id;
	String lname;
	String fname;
	int class_id;
	String email;
	String phone;
	String password;
	
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AdminTeacher(int teacher_id, String lname, String fname, int class_id, String email, String phone,
			String password) {
		super();
		this.teacher_id = teacher_id;
		this.lname = lname;
		this.fname = fname;
		this.class_id = class_id;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Teacher ID---" + teacher_id + ", Last name---" + lname + ", First name---" + fname + ", Class ID---"
				+ class_id + ", Email---" + email + ", Phone---" + phone + ", Login password---" + password;
	}
		
}
