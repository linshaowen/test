package com.gzctksxt.dao;
import java.sql.SQLException;

import com.gzctksxt.bean.User;

public interface UserDao 
{
	/**
	 * ��֤��¼�û���������
	 * @param userName
	 * @param userPassword
	 * @return
	 * @throws SQLException
	 */
	public User checklogin(String userName,String userPassword) throws SQLException;
}
