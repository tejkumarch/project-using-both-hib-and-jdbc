package com.dxc.HibDAO;

import java.util.List;

public interface UserHibDAO<E> {
	boolean update(E e);
	boolean insert(E e);
	boolean delete(String id);
	E find(String id);
	List<E> findAll();	

}
