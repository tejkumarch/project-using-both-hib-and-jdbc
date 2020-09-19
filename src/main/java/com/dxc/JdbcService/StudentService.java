package com.dxc.JdbcService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.dxc.beans.Student;
import com.dxc.jdbcDAO.StudentJdbcDAO;

public class StudentService implements Service<Student> {

	@Override
	public boolean save(Student student) {
		boolean res=false;
		try {
			StudentJdbcDAO studentJdbcDAO=new StudentJdbcDAO();
			return studentJdbcDAO.save(student);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Student find(int id) {
		Student student=null;
		try {
			StudentJdbcDAO studentJdbcDAO=new StudentJdbcDAO();
			student=studentJdbcDAO.find(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> findAll() {
		List<Student> students=null;
		try {
			StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
			students=studentJdbcDAO.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public boolean update(Student student) {
		boolean res=false;
		try {
			StudentJdbcDAO studentJdbcDAO =new StudentJdbcDAO();
			res=studentJdbcDAO.edit(student);
			if(res)
			{
				studentJdbcDAO.save();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean delete(int id) {
		boolean res = false;
		StudentJdbcDAO studentjdbcdao;
			try {
				studentjdbcdao = new StudentJdbcDAO();
				res = studentjdbcdao.delete(id);
				if(res)
				{
					studentjdbcdao.save();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return res;
	}

}
