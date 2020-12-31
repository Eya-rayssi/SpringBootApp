package com.example.BookStoreVermeg.repository;

import java.util.List;
import java.util.Optional;

import com.example.BookStoreVermeg.entity.ProductLine;

public interface ProductLineRepository {

	 public List<ProductLine> findProductLinesByCommandId(Long prodId);

	    public Optional<ProductLine> findProductLineByProductIdAndBookId(Long prodId, Long bookId);

	    public void deleteProductLinesByProductId(Long id);
}
