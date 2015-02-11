package com.gzctksxt.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gzctksxt.bean.User;
import com.gzctksxt.dao.BaseDao;
import com.gzctksxt.dao.UserDao;
import com.mysql.jdbc.Connection;

public class UserDaoImp extends BaseDao implements UserDao  {

	@Override
	public User checklogin(String userName, String userPassword)
			throws SQLException {
			User user=null;
			String sql="select * from user_tbl where user_name=? and user_password=?;";
			
			try{
				java.sql.Connection conn=cm.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
				setParamsToPs(ps, new Object[]{userName,userPassword});
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					user=(User)parseResultSetToBean(User.class, rs);
				}
				rs.close();
				ps.close();
				conn.close();
			
			}catch(Exception e){	
			}finally{
				
			}
		return user;
	}

}
