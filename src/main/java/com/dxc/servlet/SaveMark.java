package com.dxc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.beans.Mark;
import com.dxc.jdbcDAO.MarkJdbcDAO;

/**
 * Servlet implementation class SaveMark
 */
public class SaveMark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveMark() {
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
		String eid=request.getParameter("eid");
		int id=Integer.parseInt(request.getParameter("sid"));
		int m1=Integer.parseInt(request.getParameter("mark1"));
		int m2=Integer.parseInt(request.getParameter("mark2"));
		int m3=Integer.parseInt(request.getParameter("mark3"));

		try {
			Mark m=new Mark(eid, id, m1, m2, m3);
			MarkJdbcDAO markJdbcDAO=new MarkJdbcDAO();
			if(markJdbcDAO.save(m))
			{
				HttpSession session=request.getSession(true);
				RequestDispatcher r=request.getRequestDispatcher("MarkDisplay.jsp");
				r.forward(request, response);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
