package com.cqust.dao.impl;

import java.sql.*;

import com.cqust.dao.UserDao;
import com.cqust.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String user,String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1. get the database connection
			conn = JDBCUtil.getConn();
			// System.out.println("The database status:"+conn.isClosed());
			String sql = "select * from t_user where username=? and password=?";

			// 2. create PrepareStatement object
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);

			// 3.execute
			rs = ps.executeQuery();

			// if can move to next record, means the user and pass are right
			return rs.next();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

}
