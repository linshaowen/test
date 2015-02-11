package com.gzctksxt.dao;

import java.sql.SQLException;
import java.util.List;

import com.gzctksxt.bean.BaseBean;
import com.gzctksxt.bean.BaseNameBean;


public interface BaseBeanDao {
	public List selectAll(String tbl) throws SQLException;
	public List selectOne(String tbl) throws SQLException;
	public void insert(String tbl,BaseBean bb,BaseNameBean bnb) throws SQLException ;
	public List selectByName(String tableName);
public	List selectLastOne(String tableName);

}
