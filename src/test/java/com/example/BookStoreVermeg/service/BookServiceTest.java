package com.example.BookStoreVermeg.service;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.BookStoreVermeg.entity.Book;
import com.example.BookStoreVermeg.repository.BookRepository;

public class BookServiceTest {
	 @Mock
	    BookRepository bookRepository;

	     @InjectMocks
	    BookService bookService;

	    @BeforeAll
	    public static void beforeAll() {
	        System.out.println("Start testing the book service");
	    }

	    @AfterAll
	    public static void afterAll() {
	        System.out.println("End testing the book service");
	    }

	    @BeforeEach
	    public void setUp() {
	        System.out.println("The test started");
	        MockitoAnnotations.initMocks(this);
	    }

	    @AfterEach
	    public void tearDown() {
	        System.out.println("The test ended");
	    }

	    @Test
	    public void getAllTest() {
	        List<Book> books = new ArrayList<Book>();
	        books.add(new Book(new Long(1),"Onze minutes","Paulo Coelho",28));
	        books.add(new Book(new Long(2),"Les misérables","Victor Hugo",35));
	        books.add(new Book(new Long(7),"Frases","Paulo Coelho",58));
	        books.add(new Book(new Long(8),"Les misérables","Victor Hugo",45));

	        when(this.bookRepository.findAll()).thenReturn(books);
	        System.out.println(this.bookService.getAll().size());
	        System.out.println(Arrays.toString(this.bookService.getAll().toArray()));
	        assertTrue(this.bookService.getAll().size() == books.size(),
	                "Test failed: Size of list isn't equal to the size of the present test");
	    }

	    @Test
	    public void getBookByIdTest() throws ParseException {
	        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = formatter.parse("2008-01-17");
	        Book book = new Book(new Long(7),"Notre dame de paris","vctore Hugo",14, date);
	        when(this.bookRepository.findById(book.getId())).thenReturn(java.util.Optional.of(book));
	        assertEquals(7, book.getId());
	        assertSame(this.bookService.getBookById(book.getId()).getId(),book.getId(),
	             "Test failed: Not matching Book ID");
	        System.out.println(this.bookService.getBookById(book.getId()).toString());
	    }

	    @Test
	    public void addBookTest() {
	        Book book = new Book("book","book's author",4, new Date());

	        bookService.addBook(book);
	        verify(bookRepository, times(1)).save(book);
	    }

	    @Test
	    public void deleteBookTest() throws ParseException {
	        bookService.deleteBook(new Long(2));
	        verify(bookRepository, times(2)).deleteById(new Long(2));
	    }

	    @Test
	    public void updateBookTest() throws ParseException {
	        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = formatter.parse("2008-01-17");
	        Book book = new Book(new Long(7),"Onzes minutes","Paulo Coelho",14, date);
	        bookService.updateBook(book,new Long(7));
	        verify(bookRepository, times(1)).save(book);
	    }

}
