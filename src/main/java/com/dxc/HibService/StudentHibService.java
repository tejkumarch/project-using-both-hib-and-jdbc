package com.dxc.HibService;

import java.util.List;

public interface StudentHibService<E>{
	boolean save(E e);
	E find(int id);
	List<E> findAll();
	boolean update(E e);
	boolean delete(int id);
}
