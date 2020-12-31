package com.example.BookStoreVermeg.dao;

import com.example.BookStoreVermeg.entity.Book;
import com.example.BookStoreVermeg.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.hibernate.SessionFactory;

public class BookDaoImpl implements IDao<Book>{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public void find() {
		bookRepository.findAll();
	}

	@Override
	public void add(Book book) {
		bookRepository.save(book);
	}
	@Override
	public List<Book> find() {
		return this.bookRepository.getCurrentSession().createQuery("from Book").list();
	}

	@Override
	public void update(Book book) {
		bookRepository.update(book);
		
	}

	@Override
	public void delete(Book book) {
		bookRepository.delete(book);
	}

	@Override
	public Book findById(Long id) {
		return (Book) bookRepository.get(Book.class , id);
	}

}
