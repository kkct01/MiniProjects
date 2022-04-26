package com.model;

public class Student {
	
	String lname, fname, email, phone, subject, class_start, class_finish;

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getClass_start() {
		return class_start;
	}

	public void setClass_start(String class_start) {
		this.class_start = class_start;
	}

	public String getClass_finish() {
		return class_finish;
	}

	public void setClass_finish(String class_finish) {
		this.class_finish = class_finish;
	}

	public Student(String lname, String fname, String email, String phone, String subject, String class_start,
			String class_finish) {
		super();
		this.lname = lname;
		this.fname = fname;
		this.email = email;
		this.phone = phone;
		this.subject = subject;
		this.class_start = class_start;
		this.class_finish = class_finish;
	}

	@Override
	public String toString() {
		return "Student name: " + fname + lname + "|||" + "Email: " + email + "|||" + "Phone number: " + phone + "|||" + "Subject: " + subject + "|||" + "Class start: " + 
	class_start + "|||" + "Class ends: " + class_finish;
	}
	
	
	
}
