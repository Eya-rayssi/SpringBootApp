package com.example.BookStoreVermeg.service;

import java.util.List;

import com.example.BookStoreVermeg.dao.BookDaoImpl;
import com.example.BookStoreVermeg.dao.IDao;
import com.example.BookStoreVermeg.entity.Book;
import com.example.BookStoreVermeg.entity.ProductLine;

import org.springframework.transaction.annotation.Transactional;

public class BookService {
	 @Autowired
		private IDao<Book> bookDao;

	    public List<Book> getAll(){
	        return bookDao.findAll();
	    }

	    public Book getBookById(Long id) {
	        return bookDao.findById(id);
	    }

	    public Book addBook(Book book) {
	        return bookDao.save(book);
	    }

	    @Transactional
		public void update(Book book) {
			this.bookDao.update(book);
			
		}

		@Transactional
		public void delete(Book book) {
			this.bookDao.delete(book);
			
	    }
	    @Transactional 
		public double calculate(double price, int qte) {
			return price*qte;
		}
		
		@Transactional
		public double getTotalPriceOfOrder(Long id) {
			double sum = 0;
			for (ProductLine orderLine: this.bookDao.findById(id).getProductLine())
				sum += orderLine.getBook().getPrice() * orderLine.getQuantity();
			return sum;
		}


}
