package com.example.BookStoreVermeg.controller;

import com.example.BookStoreVermeg.repository.BookRepository;
import com.example.BookStoreVermeg.service.BookService;
import com.example.BookStoreVermeg.entity.Book;

@RestController
@RequestMapping("/bookstore/")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<List<Book>>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping("book/add")
    public ResponseEntity<Book> addBook(@RequestBody @Validated Book b, BindingResult result) {
        if (result.hasErrors())
            System.err.println(result.getAllErrors());
        return new ResponseEntity<Book>(bookService.addBook(b),HttpStatus.CREATED);
    }

    @DeleteMapping("book/{id}/delete")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        return new ResponseEntity<Book>(bookService.deleteBook(id), HttpStatus.OK);
    }

    @PutMapping("book/{id}/modify")
    public ResponseEntity<Book> updateBook(@RequestBody @Validated Book b, @PathVariable Long id,
                           BindingResult result) {
        if (result.hasErrors())
            System.err.println(result.getAllErrors());
        return new ResponseEntity<Book>(bookService.updateBook(b, id), HttpStatus.OK);
    }
}	
	
	

