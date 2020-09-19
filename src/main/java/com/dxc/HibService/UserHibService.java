package com.dxc.HibService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dxc.HibDAO.UserDAO;
import com.dxc.beans.User;

public class UserHibService implements StudentHibService<User> {

	@Override
	public boolean save(User user) {
		boolean res=false;
		UserDAO userHibService=new UserDAO();
		if(userHibService.insert(user))
		{
			res=true;
		}
				return res;
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static boolean validate(String username,String password)
	{
		boolean res=false;
		UserDAO userDAO=new UserDAO();
		try {
			if(userDAO.validate(username, password))
			{
				res=true;
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
}
