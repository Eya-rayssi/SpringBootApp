package com.example.BookStoreVermeg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity

public class ProductLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
    @ManyToOne
	private int quantity;
	
	@Column(name="")
	private Book book;
	
	@Column
	private Product product;

	public ProductLine(Long id, int quantity, Book book, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.book = book;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductLine() {
		super();
	}

	@Override
	public String toString() {
		return "ProductLine [id=" + id + ", quantity=" + quantity + ", book=" + book + ", product=" + product + "]";
	}
	
	

}
