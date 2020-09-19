package com.dxc.jdbcDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dxc.beans.User;
import com.dxc.Jdbcutil.ConnectionManager;	

public class UserJdbcDAO extends jdbcDAO implements DAO<User> {
	
	PreparedStatement p=null;
	ResultSet rs=null;

	public UserJdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(User e) throws Exception {
		boolean res=false;
	    
		p=con.prepareStatement("insert into users values(?,?)");

		p.setString(1, e.getUsername());
		p.setString(2, e.getPassword());
		
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;

	}

	@Override
	public boolean edit(User e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean validate(String username,String password) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		Connection con = ConnectionManager.getConnection();
		con.commit();
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
		
	}
}
