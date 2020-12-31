package com.example.BookStoreVermeg.dao;

import java.util.List;

import com.example.BookStoreVermeg.entity.Product;
import com.example.BookStoreVermeg.repository.ProductRepository;

public class ProductDao implements IDao<Product>{

	@Autowired
	ProductRepository productRepository;
	@Override
	public Product findById(Long id) {
		return (Product) productRepository.getCurrentSession().get(Product.class , id);
	}

	@Override
	public void add(Product obj) {
		productRepository.getCurrentSession().save((Product)obj);		
	}

	@Override
	public void update(Product obj) {
		productRepository.getCurrentSession().update((Product)obj);		
	}

	@Override
	public void delete(Product obj) {
		productRepository.getCurrentSession().save((Product)obj);		
	}

	@Override
	public List<Product> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
