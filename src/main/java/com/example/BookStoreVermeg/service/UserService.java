package com.example.BookStoreVermeg.service;

import java.util.List;

import com.example.BookStoreVermeg.dao.IDao;
import com.example.BookStoreVermeg.entity.User;
import org.springframework.transaction.annotation.Transactional;

public class UserService {
	@Autowired
	private IDao<User> userDao;
	
	public UserService() {}
	public UserService(IDao<User> userDao) {
		this.userDao = userDao;
	}


	@Transactional
	public List<User> find() {
		return this.userDao.find();
	}

	@Transactional
	public User findById(Long id) {
		return this.userDao.findById(id);
	}

	@Transactional
	public void add(User user) {
		this.userDao.add(user);
		
	}

	@Transactional
	public void update(User user) {
		this.userDao.update(user);
		
	}

	@Transactional
	public void delete(User user) {
		this.userDao.delete(user);
		
	}

}
