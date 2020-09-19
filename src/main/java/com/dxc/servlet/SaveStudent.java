package com.dxc.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.beans.Student;
import com.dxc.HibService.StudentHibServiceImp;

/**
 * Servlet implementation class SaveStudent
 */
public class SaveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		try {
			Student s=new Student(id, name, dob, email, mobile);
			StudentHibServiceImp studentService=new StudentHibServiceImp();
			if(studentService.save(s))
			{
				HttpSession session=request.getSession(true);
				RequestDispatcher r=request.getRequestDispatcher("Display.jsp");
				r.forward(request, response);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
