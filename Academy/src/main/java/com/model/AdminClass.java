package com.model;

public class AdminClass {

	int class_id;
	String start;
	String finish;
	int teacher_id;
	String subject;
	String lname;
	String fname;
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public AdminClass(int class_id, String start, String finish, int teacher_id, String subject, String lname,
			String fname) {
		super();
		this.class_id = class_id;
		this.start = start;
		this.finish = finish;
		this.teacher_id = teacher_id;
		this.subject = subject;
		this.lname = lname;
		this.fname = fname;
	}
	
	@Override
	public String toString() {
		return "Class ID---" + class_id + ", Start date---" + start + ", End date---" + finish + ", Subject---" + subject + ", Teacher ID---"
				+ teacher_id + ", Teacher's last name---" + lname + ", Teacher's first name---" + fname;
	}
	
	
	
	

}
