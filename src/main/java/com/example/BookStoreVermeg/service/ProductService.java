package com.example.BookStoreVermeg.service;

import java.util.List;

import com.example.BookStoreVermeg.dao.IDao;
import com.example.BookStoreVermeg.entity.Product;

public class ProductService {

	@Autowired
	private IDao<Product> productDao;
	
	@Transactional
	public List<Product> find() {
		return this.productDao.find();
	}
	
	@Transactional
	public Product findById(Long id) {
		return this.productDao.findById(id);
	}
	
	@Transactional
	public void add(Product product) {
		this.productDao.add(product);
	}
	
	@Transactional
	public void update(Product product) {
		this.productDao.update(product);
	}
	
	@Transactional
	public void delete(Product product) {
		this.productDao.delete(product);
	}
	
}


