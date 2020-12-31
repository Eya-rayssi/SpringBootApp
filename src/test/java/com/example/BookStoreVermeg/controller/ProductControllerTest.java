package com.example.BookStoreVermeg.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.BookStoreVermeg.entity.Product;

@SpringBootTest
	@AutoConfigureMockMvc(addFilters = false)
	public class ProductControllerTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @Mock
	    ProductService productService;

	    @InjectMocks
	    ProductController productController;
	    private String url= "http://localhost:8080/product/";

	    @BeforeAll
	    public static void beforeAll() {
	        System.out.println("Testiong the start of product controller");
	    }

	    @AfterAll
	    public static void afterAll() {
	        System.out.println("Testing the end of product controller");
	    }


	    @BeforeEach
	    public void setUp() {
	        System.out.println("The test started");
	    }

	    @AfterEach
	    public void tearDown() {
	        System.out.println("The test ended");
	    }


	    @Test
	    void getAllProductTest() throws Exception {
	        List<Product> prods = new ArrayList<>();
	        when(productService.getAllProducts()).thenReturn(prods);

	        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url))
	                .andDo(print())
	                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
	                .andExpect(status().isOk());
	    }

	    @Test
	    void getCommandByIdTest() throws Exception {
	        Product product= new Product();

	        when(productService.getCmdById(anyLong())).thenReturn(product);

	        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url+10))
	                .andDo(print())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(10))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.user.id").value(1))
	                .andExpect(status().isOk());
	    }

	    @Test
	    void getCommandByUserTest() throws Exception {
	        List<Product> prods = new ArrayList<>();

	        when(productService.getUserProducts(anyLong())).thenReturn(prods);

	        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url+"user/1"))
	                .andDo(print())
	                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)))
	                .andExpect(status().isOk());
	    }

	    @Test
	    void deleteCommandTest() throws Exception {
	        Command command = new Command();

	        when(commandService.deleteCommand(anyLong())).thenReturn(command);

	        mockMvc.perform(MockMvcRequestBuilders.delete(url+13)
	                .content(new ObjectMapper().writeValueAsString(command))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andDo(print());
	    }

	    @Test
	    void windUpCommandTest() throws Exception {
	        double total = 0;
	        when(commandService.windUpCommand(anyLong())).thenReturn(total);

	        mockMvc.perform(MockMvcRequestBuilders.put(url+10)
	                .content(new ObjectMapper().writeValueAsString(total))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andDo(print());
	    }

	    @Test
	    void getTotalTest() throws Exception {
	        double total = 0;
	        mockMvc.perform(MockMvcRequestBuilders.put(url+10)
	                .content(new ObjectMapper().writeValueAsString(total))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andDo(print());
	    }
}
