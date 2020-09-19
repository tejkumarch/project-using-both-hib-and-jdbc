package com.dxc.HibService;

import java.util.List;

import com.dxc.HibDAO.StudentHibDAO;
import com.dxc.beans.Student;

public class StudentHibServiceImp implements StudentHibService<Student> {

	@Override
	public boolean save(Student student) {
		boolean res=false;
		StudentHibDAO studentHibDAO=new StudentHibDAO();
		if(studentHibDAO.insert(student))
		{
			res=true;
		}
		return res;
	}

	@Override
	public Student find(int id) {
		StudentHibDAO studentHibDAO=new StudentHibDAO();
		Student student=studentHibDAO.find(id);
		return student;
	}

	@Override
	public List<Student> findAll() {
		StudentHibDAO studentHibDAO=new StudentHibDAO();
		List<Student> students=studentHibDAO.findAll();
		return students;
	}

	@Override
	public boolean update(Student student) {
		boolean res=false;
		StudentHibDAO studentHibDAO=new StudentHibDAO();
			if(studentHibDAO.update(student))
			{
				res=true;
			}
		return res;
	}

	@Override
	public boolean delete(int id) {
		boolean res = false;
		StudentHibDAO studentHibDAO=new StudentHibDAO();
		if(studentHibDAO.delete(id))
			{
				res=true;
			}
			
		return res;
	}

}
