package com.example.BookStoreVermeg.dao;

import java.util.List;

public interface IDao<A> {
	public A findById(Long id);
	List<A> find();
	public void add(A obj);
	public void update(A obj);
	public void delete(A obj);
	

}
