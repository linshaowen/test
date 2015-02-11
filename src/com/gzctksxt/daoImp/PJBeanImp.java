package com.gzctksxt.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gzctksxt.bean.PJBean;
import com.gzctksxt.bean.PJBean;
import com.gzctksxt.dao.PJBeanDao;
import com.gzctksxt.dao.PJDao;

public class PJBeanImp extends PJDao implements PJBeanDao {
	public List selectAll(String tbl) throws SQLException {
		List list=new ArrayList<PJBean>();
			PJBean pjb=null;
			String sql=" select * from (select * from zd order by rq desc ) a where TO_DAYS(a.rq) in(select max(TO_DAYS(rq)) as rq from zd ) group by name ;";
			try{
				java.sql.Connection conn=cm.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
//				ps.setString(1,tbl);
//				setParamsToPs(ps, new Object[]{tbl});
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					pjb=(PJBean)parseResultSetToBean(PJBean.class, rs);
//					pjb.setRq(rs.getTimestamp("rq"));
					list.add(pjb);
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
		List list=new ArrayList<PJBean>();
			PJBean pjb=null;
			String sql="select * from "+tbl+" order by id desc limit 0,1;";
	
			try{
				java.sql.Connection conn=cm.getConnection();
				PreparedStatement ps=conn.prepareStatement(sql);
		
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					pjb=(PJBean)parseResultSetToBean(PJBean.class, rs);
					pjb.setRq(rs.getTimestamp("rq"));
					list.add(pjb);
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
	public void insert(String tbl,PJBean pjb) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into "+tbl+"(name,zb,fhl,wcjd,hbts,rq)values(?,?,?,?,?,?);";
//		String sql2="insert into "+tbl+"(ydyw,kdyw,fhl,ydwcjd,zlkd)values(0,0,null,null,null);";
//		System.out.println(sql);
		try {
//			PreparedStatement ps2=cm.getConnection().prepareStatement(sql2);
//			ps2.execute();
			java.sql.Connection conn=cm.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			setParamsToPs(ps, new Object[]{pjb.getName(),pjb.getZb(),pjb.getFhl(),pjb.getWcjd(),pjb.getHbts(),pjb.getRq()});
//			ps.setString(1,current_time );
			
//			System.out.println(pjb.getYdyw()+pjb.getKdyw()+pjb.getFhl());
			ps.execute();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
//			cm.getConnection().close();
		}
		
	}

	


}
