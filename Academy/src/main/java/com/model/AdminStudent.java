package com.model;

public class AdminStudent {

	int student_id;
	String slname, sfname, subject, start, finish, tlname, tfname;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getSlname() {
		return slname;
	}
	public void setSlname(String slname) {
		this.slname = slname;
	}
	public String getSfname() {
		return sfname;
	}
	public void setSfname(String sfname) {
		this.sfname = sfname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getTlname() {
		return tlname;
	}
	public void setTlname(String tlname) {
		this.tlname = tlname;
	}
	public String getTfname() {
		return tfname;
	}
	public void setTfname(String tfname) {
		this.tfname = tfname;
	}
	public AdminStudent(int student_id, String slname, String sfname, String subject, String start, String finish,
			String tlname, String tfname) {
		super();
		this.student_id = student_id;
		this.slname = slname;
		this.sfname = sfname;
		this.subject = subject;
		this.start = start;
		this.finish = finish;
		this.tlname = tlname;
		this.tfname = tfname;
	}
	@Override
	public String toString() {
		return "Student ID---" + student_id + ", Student's last name---" + slname + ", Student's first name---" + sfname + ", Subject---"
				+ subject + ", Start Date---" + start + ", End Date---" + finish + ", Teacher's last name---" + tlname + ","
						+ " Teacher's first name---" + tfname;
	}
	
	

}
