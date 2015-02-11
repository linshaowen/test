package com.gzctksxt.dao;

import java.sql.SQLException;
import java.util.List;

import com.gzctksxt.bean.BaseBean;
import com.gzctksxt.bean.PJBean;


public interface PJBeanDao {
	public List selectAll(String tbl) throws SQLException;
	public List selectOne(String tbl) throws SQLException;

	void insert(String tbl, PJBean pjb) throws SQLException;

}