package com.gzctksxt.dao;
import java.sql.SQLException;

import com.gzctksxt.bean.User;

public interface UserDao 
{
	/**
	 * 验证登录用户名和密码
	 * @param userName
	 * @param userPassword
	 * @return
	 * @throws SQLException
	 */
	public User checklogin(String userName,String userPassword) throws SQLException;
}
