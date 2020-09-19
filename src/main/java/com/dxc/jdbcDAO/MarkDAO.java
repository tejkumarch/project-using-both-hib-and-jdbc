package com.dxc.jdbcDAO;

import java.util.List;

public interface MarkDAO<E> {
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(String examid,int studentid) throws Exception;
	E find(String examid,int studentid) throws Exception;
	List<E> findAll() throws Exception;	
}
