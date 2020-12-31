package com.example.BookStoreVermeg.controller;

import com.example.BookStoreVermeg.entity.Product;
import com.example.BookStoreVermeg.repository.ProductRepository;
import com.example.BookStoreVermeg.service.ProductService;

import java.util.List;

public class ProductController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductService productService;
	
	@GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<List<Product>>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProdById(id), HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<List<Product>> getProductByUser(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getUserProducts(id), HttpStatus.OK);
    }

    @PostMapping("new")
    public ResponseEntity<Product> createProduct(@RequestBody @Validated Product prod) {
        return new ResponseEntity<>(productService.createProduct(prod), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.deleteCommand(id), HttpStatus.OK);
    }

    @GetMapping("{id}/total")
    public ResponseEntity<Double> getTotal(@PathVariable Long id){
        return new ResponseEntity<>(productService.getTotalPrice(id), HttpStatus.OK);
    }
}