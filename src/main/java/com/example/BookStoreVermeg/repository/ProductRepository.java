package com.example.BookStoreVermeg.repository;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import com.example.BookStoreVermeg.entity.Product;

public interface ProductRepository extends JpaRepository{
	  public List<Product> getCommandsByDate(Date cmdDate);

	    public Optional<Product> findCommandByUserIdAndAndWindedUp(Long userId, boolean windedUp);

	    public List<Product> getCommandsByUserId(Long userId);
	}

