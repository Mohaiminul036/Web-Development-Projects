package com.cqust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cqust.dao.StuDao;
import com.cqust.domain.Student;
import com.cqust.util.JDBCUtil;

public class StuDaoImpl implements StuDao {

	@Override
	public List<Student> findAll() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();

		try {
			// 1. get the database connection
			conn = JDBCUtil.getConn();
			// System.out.println("The database status:"+conn.isClosed());
			String sql = "select * from t_stu";

			// 2. create PrepareStatement object
			ps = conn.prepareStatement(sql);

			// 3.execute
			rs = ps.executeQuery();
			// List<Student> list=new ArrayList<Student>();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				stu.setName(rs.getString("name"));
				stu.setAddress(rs.getString("address"));
				stu.setGender(rs.getString("gender"));

				list.add(stu);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}

		return list;
	}

	@Override
	public boolean addStudent(String name, int age, String address, String gender) {
		Connection conn = null;
		PreparedStatement ps = null;
		int res = 0;
		
		try {
			// 1. get the database connection
			conn = JDBCUtil.getConn();
			
			String sql = "insert into t_stu(name,age,gender,address) values(?,?,?,?)";

			// 2. create PrepareStatement object
			ps = conn.prepareStatement(sql);
			
			Student stu = new Student();
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.setString(4, address);

			res = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps);
		}
		
		if (res > 0){
			return true;
		}
		else{
			return false;
		}
	}
 		
}
