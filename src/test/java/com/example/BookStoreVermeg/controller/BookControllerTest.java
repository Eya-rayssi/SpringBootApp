package com.example.BookStoreVermeg.controller;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import com.example.BookStoreVermeg.entity.Book;
import com.example.BookStoreVermeg.service.BookService;

public class BookControllerTest {
	
	   
	 @Autowired
		private MockMvc mockMvc;

		@Mock
		private BookService MockedBookService;

		@InjectMocks
		private BookController bookController;

		@Before
		public void setup() throws Exception {
			
			MockitoAnnotations.initMocks(this);
			mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
		}

		@Test
		public void testGetAllBooks() throws Exception {
			List <Book> books = new ArrayList<Book>();
			books.add(new Book("title1","author1",50d,null));
			books.add(new Book("title2","author2",10d,null));
			books.add(new Book("title3","author3",20d,null));
			
			when(MockedBookService.find()).thenReturn(books);

			this.mockMvc.perform(get("/book/all"))
			.andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
			.andExpect(status().is2xxSuccessful());
			
		}

		@Test
		public void testGetBook() throws Exception {
			Book book = new Book(4,"title4","author4",100d,null);
			when(MockedBookService.findById(1)).thenReturn(book);
			this.mockMvc.perform(get("/book/get/{id}", 1))
			.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(4))
			.andExpect(status().is2xxSuccessful());
		}


}
