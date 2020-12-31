package com.example.BookStoreVermeg.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookStoreVermeg.entity.Book;
public interface BookRepository extends JpaRepository<Book, Long>{

}