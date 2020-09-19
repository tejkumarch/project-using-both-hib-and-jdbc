package com.dxc.HibDAO;

import java.util.List;

public interface HibDAO<E>{
	
	boolean update(E e);
	boolean insert(E e);
	boolean delete(int id);
	E find(int id);
	List<E> findAll();	

}
