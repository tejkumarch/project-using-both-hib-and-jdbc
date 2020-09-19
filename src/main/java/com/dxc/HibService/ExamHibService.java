package com.dxc.HibService;
import java.util.List;

import com.dxc.HibDAO.ExamHibDAO;
import com.dxc.beans.Exam;
import com.dxc.beans.Student;


public class ExamHibService implements ExamHibServiceInterface<Exam> {

	@Override
	public boolean save(Exam exam) {
		boolean res=false;
		ExamHibDAO examHibDAO=new ExamHibDAO();
		if(examHibDAO.insert(exam))
		{
			res=true;
		}
		return res;
	}

	@Override
	public Exam find(String id) {
		ExamHibDAO examHibDAO=new ExamHibDAO();
		Exam exam=examHibDAO.find(id);
		return exam;
	}

	@Override
	public List<Exam> findAll() {
		ExamHibDAO examHibDAO=new ExamHibDAO();
		List<Exam> exams=examHibDAO.findAll();
		return exams;
	}

	@Override
	public boolean update(Exam exam) {
		boolean res=false;
		ExamHibDAO examHibDAO=new ExamHibDAO();
			
			if(examHibDAO.update(exam))
			{
				res=true;
			}
		return res;
	}

	@Override
	public boolean delete(String id) {
		boolean res = false;
		ExamHibDAO examHibDAO=new ExamHibDAO();
		if(examHibDAO.delete(id))
			{
				res=true;
			}
			
		return res;
	}

}
