package com.dxc.jdbcDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.dxc.Jdbcutil.ConnectionManager;

public class jdbcDAO {
	Connection con=null;
	public jdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		con=ConnectionManager.getConnection();
		con.setAutoCommit(false);
		
	}
	
	public void save() throws SQLException
	{
		con.commit();
		con.close();
	}
	public void undo() throws SQLException
	{
		con.rollback();
		con.close();
	}
}
