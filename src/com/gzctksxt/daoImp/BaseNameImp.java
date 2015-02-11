package com.gzctksxt.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gzctksxt.bean.BaseBean;
import com.gzctksxt.bean.BaseNameBean;
import com.gzctksxt.dao.BaseDao;
import com.gzctksxt.dao.BaseNameDao;

public class BaseNameImp extends BaseDao implements BaseNameDao{

	@Override
	public void insert(String tbl,BaseNameBean bnb) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into "+tbl+" (l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10)values(?,?,?,?,?,?,?,?,?,?,?);";
		Connection conn=cm.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		setParamsToPs(ps, new Object[]{bnb.getL0(),bnb.getL1(),bnb.getL2(),bnb.getL3(),bnb.getL4(),bnb.getL5(),bnb.getL6(),bnb.getL7(),bnb.getL8(),bnb.getL9(),bnb.getL10()});
	
		ps.execute();
		ps.close();
		conn.close();
	}
	
	public List selectAll(String tbl) throws SQLException {
		List list=new ArrayList<BaseBean>();
			BaseNameBean bnb=null;
			String sql=null;
		   sql="";

			try{
				java.sql.Connection conn=cm.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
//				ps.setString(1,tbl);
				
//				setParamsToPs(ps, new Object[]{tbl});
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					bnb=(BaseNameBean)parseResultSetToBean(BaseBean.class, rs);
//					bnb.setRq(rs.getTimestamp("rq"));
					list.add(bnb);
				}
				rs.close();
				ps.close();
				conn.close();
				
			}catch(Exception e){	
			}finally{
				
			}
		return list;
	}
	
	public List selectLastOne(String tableName) {
		BaseNameBean bnb=null;
		List list=new ArrayList<BaseNameBean>();
		String sql="select * from "+tableName+" order by id desc limit 0,1";
		try {
			java.sql.Connection conn=cm.getConnection();
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next())
			{
				bnb=(BaseNameBean) parseResultSetToBean(BaseNameBean.class, rs);

				list.add(bnb);
			}
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
