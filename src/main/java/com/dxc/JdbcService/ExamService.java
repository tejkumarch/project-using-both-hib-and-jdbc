package com.dxc.JdbcService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


import com.dxc.beans.Exam;
import com.dxc.jdbcDAO.ExamJdbcDAO;


public class ExamService implements ExamServiceI<Exam> {

	@Override
	public boolean save(Exam exam) {
		boolean res=false;
		try {
			ExamJdbcDAO examJdbcDAO=new ExamJdbcDAO();
			return examJdbcDAO.save(exam);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return res;
	}

	@Override
	public Exam find(String id) {
		
		Exam exam=null;
		
		try {
			ExamJdbcDAO examJdbcDAO=new ExamJdbcDAO();
			exam=examJdbcDAO.find(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exam;
	}

	@Override
	public List<Exam> findAll() {
		List<Exam> exams=null;
		try {
			ExamJdbcDAO examJdbcDAO = new ExamJdbcDAO();
			exams=examJdbcDAO.findAll();
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
		return exams;

	}

	@Override
	public boolean update(Exam e) {
		boolean res=false;
			try {
				ExamJdbcDAO examJdbcDAO =new ExamJdbcDAO();
				res=examJdbcDAO.edit(e);
				if(res)
				{
					examJdbcDAO.save();
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return res;
	}

	@Override
	public boolean delete(String id) {
		boolean res = false;
		ExamJdbcDAO examJdbcDAO;
			try {
				examJdbcDAO = new ExamJdbcDAO();
				res = examJdbcDAO.delete(id);
				if(res)
				{
					examJdbcDAO.save();
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
