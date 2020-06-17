package com.cqust.dao;


public interface UserDao {
	/**
	 * @return true:logined successfully,false:login failed
	 * @param  userName
	 * @param  password
	 */
	
	boolean login(String user,String pass);
}
