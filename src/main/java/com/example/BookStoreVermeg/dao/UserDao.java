package com.example.BookStoreVermeg.dao;

import java.util.List;

import com.example.BookStoreVermeg.entity.User;
import com.example.BookStoreVermeg.repository.UserRepository;

public class UserDao implements IDao<User>{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findById(Long id) {
		return userRepository.getCurrentSession.get(User.class , id);
	}

	@Override
	public void add(User obj) {
		userRepository.getCurrentSession().save((User)obj);		
	}

	@Override
	public void update(User obj) {
		userRepository.getCurrentSession().update((User)obj);	
	}
	@Override
	public List<User> find() {
		return userRepository.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void delete(User obj) {
		userRepository.getCurrentSession().delete((User)obj);
		
	}

}
