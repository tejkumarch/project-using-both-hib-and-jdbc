package com.dxc.HibService;

import java.util.List;

public interface ExamHibServiceInterface<E> {
	boolean save(E e);
	E find(String id);
	List<E> findAll();
	boolean update(E e);
	boolean delete(String id);


}
