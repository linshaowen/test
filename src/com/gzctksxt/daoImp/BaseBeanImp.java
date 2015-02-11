package com.gzctksxt.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gzctksxt.bean.BaseBean;
import com.gzctksxt.bean.BaseNameBean;
import com.gzctksxt.dao.BaseBeanDao;
import com.gzctksxt.dao.BaseDao;
import com.mysql.jdbc.Connection;

public class BaseBeanImp extends BaseDao implements BaseBeanDao {
	public List selectAll(String tbl) throws SQLException {
		List list=new ArrayList<BaseBean>();
			BaseBean bb=null;
			String sql=null;
		   sql="select * from "+tbl+" a where TO_DAYS(a.rq) in(select max(TO_DAYS(rq)) as rq from "+tbl+" )  order by id ;";
//sql="select * from kd";
			try{
				java.sql.Connection conn=cm.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
//				ps.setString(1,tbl);
				
//				setParamsToPs(ps, new Object[]{tbl});
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					bb=(BaseBean)parseResultSetToBean(BaseBean.class, rs);
//					bb.setRq(rs.getTimestamp("rq"));
					list.add(bb);
				}
				rs.close();
				ps.close();
				conn.close();
				
			}catch(Exception e){	
			}finally{
				
			}
		return list;
	}
	
	public List selectOne(String tbl) throws SQLException {
		List list=new ArrayList<BaseBean>();
			BaseBean bb=null;
			String sql="select * from "+tbl+" order by id desc limit 0,2; ";
	
			try{
				java.sql.Connection conn=cm.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
		
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					bb=(BaseBean)parseResultSetToBean(BaseBean.class, rs);
//					bb.setRq(rs.getTimestamp("rq"));
					list.add(bb);
				}
				
				rs.close();
				ps.close();
				conn.close();
				
			}catch(Exception e){	
			}finally{
			
			}
		return list;
	}
	@Override
	public void insert(String tbl,BaseBean bb,BaseNameBean bnb) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql="insert into "+tbl+"(l0,l1,l2,l3,l4,l5,l6,l7,l8,l9)values(?,?,?,?,?,?,?,?,?,?);";
		
		try {
			java.sql.Connection conn=cm.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			if(bb==null)
			{
				setParamsToPs(ps, new Object[]{bnb.getL0(),bnb.getL1(),bnb.getL2(),bnb.getL3(),bnb.getL4(),bnb.getL5(),bnb.getL6(),bnb.getL7(),bnb.getL8(),bnb.getL9()});
				System.out.println("this is bnb");
			}else
			{
				System.out.println("this is bb");
				
				setParamsToPs(ps, new Object[]{bb.getL0(),bb.getL1(),bb.getL2(),bb.getL3(),bb.getL4(),bb.getL5(),bb.getL6(),bb.getL7(),bb.getL8(),bb.getL9()});
			}
//			setParamsToPs(ps, new Object[]{bb.getName(),bb.getFhl(),bb.getYs(),bb.getWcjd(),bb.getHbts(),bb.getTbts(),bb.getRq()});

			ps.execute();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public List selectLastOne(String tableName) {
		BaseBean bb=null;
		List list=new ArrayList<BaseBean>();
		String sql="select * from "+tableName+" order by id desc limit 0,1";
		try {
			java.sql.Connection conn=cm.getConnection();
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next())
			{
				bb=(BaseBean) parseResultSetToBean(BaseBean.class, rs);

				list.add(bb);
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
	
	@Override
	public List selectByName(String tableName) {
		BaseBean bb=null;
		List list=new ArrayList<BaseBean>();
//		String sql="select * from (select * from "+tableName+" where name='"+name+"') a where rq in (select max(rq) from (select * from "+tableName+" where name='"+name+"') b where cast(a.rq as date) = cast(b.rq as date)) order by rq desc limit 0,7";
		String sql="select * from "+tableName+" a where l0='合计' and rq in (select max(rq) from "+tableName+" b where cast(a.rq as date) = cast(b.rq as date)) order by rq desc limit 0,7;";

		try {
			java.sql.Connection conn=cm.getConnection();
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next())
			{
				bb=(BaseBean) parseResultSetToBean(BaseBean.class, rs);
				bb.setRq(rs.getTimestamp("rq"));
				list.add(bb);
			}
			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			
		}
		return list;
	}
	
}
