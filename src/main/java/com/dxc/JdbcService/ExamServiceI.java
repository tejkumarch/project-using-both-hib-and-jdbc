package com.dxc.JdbcService;

import java.util.List;

public interface ExamServiceI<E> {
	boolean save(E e);
	E find(String id);
	List<E> findAll();
	boolean update(E e);
	boolean delete(String id);


}
