package com.dxc.jdbcDAO;

import java.util.List;

public interface ExamDAO<E> {
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(String id) throws Exception;
	E find(String id) throws Exception;
	List<E> findAll() throws Exception;	
}
