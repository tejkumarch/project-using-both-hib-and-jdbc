package com.dxc.jdbcDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Student;
import com.dxc.Jdbcutil.ConnectionManager;

public class StudentJdbcDAO extends jdbcDAO implements DAO<Student>{

	PreparedStatement p=null;
	ResultSet rs=null;

	public StudentJdbcDAO() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		super();
	}
	
	@Override
	public boolean save(Student e1) throws SQLException{
				boolean res=false;
		    
				p=con.prepareStatement("insert into student values(?,?,?,?,?)");

				p.setInt(1, e1.getStudentid());
				p.setString(2, e1.getName());
				p.setDate(3, new Date(e1.getDob().getTime()));
				p.setString(4, e1.getEmail());
				p.setString(5, e1.getMobile());
				
				if(1==p.executeUpdate())
				{
					res=true;
				}
				con.commit();
				con.close();
				return res;
	}

	@Override
	public boolean edit(Student e1) throws SQLException{
		boolean res=false;
		
		String sql="update student set name=?,dob=?,email=?,mobile=? where studentid=?";
		
		p=con.prepareStatement(sql);
		
		p.setString(1,e1.getName());
		p.setDate(2,new Date(e1.getDob().getTime()));
		p.setString(3,e1.getEmail());
		p.setString(4,e1.getMobile());
		p.setInt(5, e1.getStudentid());
		if(1==p.executeUpdate())
		{
			res=true;	
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public boolean delete(int id) throws SQLException, ParseException{
		// TODO Auto-generated method stub
		boolean res=false;
		p=con.prepareStatement("delete from student where studentid=?");
		p.setInt(1, id);
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public Student find(int id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		Student student=null;
		try {
		con=ConnectionManager.getConnection();
		p=con.prepareStatement("select * from student where studentid=?");
		
		p.setInt(1,id);
		
		rs=p.executeQuery();
		
		if(rs.next())
		{
			String name=rs.getString(2);
			java.util.Date dd=rs.getDate(3);
			String strdob=new SimpleDateFormat("dd-MM-yyyy").format(dd);
			String email=rs.getString(4);
			String mobile=rs.getString(5);
			
			student =new Student(id, name, strdob, email, mobile);
		}
		}
		finally
		{
			con.close();
		}
		return student;
	}

	@Override
	public List<Student> findAll() throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException{
		
		ArrayList<Student> students=new ArrayList<>();
		try {
		con=ConnectionManager.getConnection();
		con.commit();
		Statement stmt=con.createStatement();
		
		rs=stmt.executeQuery("select * from student");
		
		while(rs.next())
		{
		int id=rs.getInt("studentid");
		String name=rs.getString("name");
		java.util.Date dd=rs.getDate(3);
		String strdob=new SimpleDateFormat("dd-MM-yyyy").format(dd);
		String email=rs.getString(4);
		String mobile=rs.getString(5);
		
		Student student =new Student(id, name, strdob, email, mobile);
		students.add(student);
		
	}
		}
		finally {
			con.close();
		}
		return students;
	}

		// TODO Auto-generated method stub
	
}
