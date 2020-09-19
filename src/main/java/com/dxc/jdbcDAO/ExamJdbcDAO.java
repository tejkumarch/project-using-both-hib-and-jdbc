package com.dxc.jdbcDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Exam;
import com.dxc.Jdbcutil.ConnectionManager;


public class ExamJdbcDAO extends jdbcDAO implements ExamDAO<Exam> {
	
	PreparedStatement p=null;
	ResultSet rs=null;
	
	public ExamJdbcDAO() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		super();

	}

	@Override
	public boolean save(Exam e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		
		p=con.prepareStatement("insert into exam values(?,?)");
		p.setString(1, e.getExamid());
		p.setString(2,e.getName());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public boolean edit(Exam e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		p=con.prepareStatement("update exam set name=? where examid=?");
		p.setString(1, e.getExamid());
		p.setString(2,e.getName());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public boolean delete(String id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		boolean res=false;
		p=con.prepareStatement("delete from exam where examid=?");
		p.setString(1,id);
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public Exam find(String id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		Exam exam=null;
		try {
		con=ConnectionManager.getConnection();
		p=con.prepareStatement("select * from student where studentid=?");
		
		p.setString(1,id);
		
		rs=p.executeQuery();
		if(rs.next())
		{
			String name=rs.getString("name");
			exam=new Exam(id, name);
		}
		}
		finally
		{
			con.close();
		}

		return exam;
	}

	@Override
	public List<Exam> findAll() throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		List<Exam> exams=new ArrayList<>();
		Exam exam=null;
		try {
			con=ConnectionManager.getConnection();
			con.commit();
			Statement stmt=con.createStatement();
			
			rs=stmt.executeQuery("select * from exam");
		while(rs.next())
		{
			String eid=rs.getString("examid");
			String ename=rs.getString("name");
			exam=new Exam(eid, ename);
			exams.add(exam);
		}
		}
		finally {
			con.close();
		}
		return exams;
	}

}
