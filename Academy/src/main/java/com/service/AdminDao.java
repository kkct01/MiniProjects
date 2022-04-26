package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.AdminClass;
import com.model.AdminStudent;
import com.model.AdminTeacher;
import com.model.Student;
import com.model.Teacher;

public class AdminDao {

	public AdminDao() {

	}

	public static Connection con;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/academy", "root", "password");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public int validate(String student_email, String student_pword) throws SQLException {
		int result = 0;

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("select email from students where email=? and password=?");
		ps.setString(1, student_email);
		ps.setString(2, student_pword);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			result++;
		}
		con.close();
		return result;
	}

	public int staffValidate(String teacher_email, String teacher_pword) throws SQLException {
		int result = 0;

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("select email from teachers where email=? and password=?");
		ps.setString(1, teacher_email);
		ps.setString(2, teacher_pword);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			result++;
		}
		con.close();
		return result;
	}

	public Student printStudentDetails(String student_email) throws SQLException {
		Student student = null;

		Connection con = getConnection();
		String sql = "select lname, fname, email, phone, subject, start, finish from students left join classes on students.class_id=classes.class_id where email=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, student_email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
		return student;
	}

	public Teacher printTeacherDetails(String teacher_email) throws SQLException {
		Teacher teacher = null;

		Connection con = getConnection();
		String sql = "select lname, fname, email, phone, subject, start, finish from teachers left join classes on teachers.class_id=classes.class_id where email=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, teacher_email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				teacher = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
		return teacher;
	}

	public int addClass(String subject, String start_date, String end_date, int teacher_id) throws SQLException {
		Connection con = getConnection();
		int status = 0;
		String sql = "insert into classes (start, finish, teacher_id, subject) values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, start_date);
		ps.setString(2, end_date);
		ps.setInt(3, teacher_id);
		ps.setString(4, subject);
		status = ps.executeUpdate();
		con.close();
		return status;
	}

	public int deleteClass(String class_id) throws SQLException {
		Connection con = getConnection();
		int status = 0;
		String sql = "delete from classes where class_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, class_id);
		status = ps.executeUpdate();
		con.close();
		return status;
	}

	public List<AdminClass> printClassDetails() throws SQLException {

		Connection con = getConnection();
		List<AdminClass> list = new ArrayList<>();
		String sql = "select classes.class_id, finish, start, classes.teacher_id, subject, lname, fname from classes left join teachers on classes.teacher_id=teachers.teacher_id";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminClass adminClass = new AdminClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(adminClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
		return list;
	}

	public int addTeacher(String lname, String fname, int class_id, String email, String phone, String password)
			throws SQLException {
		Connection con = getConnection();
		int status = 0;
		String sql = "insert into teachers (lname, fname, class_id, email, phone, password) values (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, lname);
		ps.setString(2, fname);
		ps.setInt(3, class_id);
		ps.setString(4, email);
		ps.setString(5, phone);
		ps.setString(6, password);
		status = ps.executeUpdate();
		con.close();
		return status;
	}

	public List<AdminTeacher> printAdminTeacherDetails() throws SQLException {
		List<AdminTeacher> list = new ArrayList<>();
		Connection con = getConnection();
		String sql = "select * from teachers";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminTeacher adminTeacher = new AdminTeacher(rs.getInt("teacher_id"), rs.getString("lname"),
						rs.getString("fname"), rs.getInt("class_id"), rs.getString("email"), rs.getString("phone"),
						rs.getString("password"));
				list.add(adminTeacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
		return list;
	}

	public int deleteTeacher(String teacher_id) throws SQLException {
		Connection con = getConnection();
		int status = 0;
		String sql = "delete from teachers where teacher_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, teacher_id);
		status = ps.executeUpdate();
		con.close();
		return status;
	}

	public int assignClassToTeacher(String class_id, String teacher_id) throws SQLException {
		int status = 0;
		Connection con = getConnection();
		String sql = "update classes set teacher_id=? where class_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, teacher_id);
		ps.setString(2, class_id);
		status = ps.executeUpdate();
		con.close();
		return status;
	}

	public int assignSubjectToClass(String class_id, String subject) throws SQLException {
		int status = 0;
		Connection con = getConnection();
		String sql = "update classes set subject=? where class_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, subject);
		ps.setString(2, class_id);
		status = ps.executeUpdate();
		con.close();
		return status;
	}

	public List<AdminStudent> printAdminStudentDetails() throws SQLException {
		List<AdminStudent> list = new ArrayList<>();
		Connection con = getConnection();
		String sql = "select students.student_id, students.lname, students.fname, subject, start, finish, teachers.lname, teachers.fname \r\n"
				+ "from students\r\n" + "left join classes on students.class_id=classes.class_id\r\n"
				+ "left join teachers on classes.class_id=teachers.class_id";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminStudent adminStudent = new AdminStudent(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				list.add(adminStudent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
		return list;
	}

}
