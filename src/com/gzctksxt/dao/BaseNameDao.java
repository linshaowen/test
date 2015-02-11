package com.gzctksxt.dao;

import java.sql.SQLException;
import java.util.List;

import com.gzctksxt.bean.BaseNameBean;

public interface BaseNameDao {
	public List selectLastOne(String tableName);
	void insert(String tbl, BaseNameBean bnb) throws SQLException;
	public List selectAll(String tbl) throws SQLException;
}
