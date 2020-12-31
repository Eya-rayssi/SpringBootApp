package com.example.BookStoreVermeg.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.BookStoreVermeg.entity.User;
import com.example.BookStoreVermeg.repository.UserRepository;

public class UserServiceTest {
	 @Mock
	    UserRepository userRepository;

	    @InjectMocks
	    UserService userService;

	    @BeforeAll
	    public static void beforeAll() {
	        System.out.println("Start testing the user service");
	    }

	    @AfterAll
	    public static void afterAll() {
	        System.out.println("End testing the user service");
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
	    public void getUserByIdTest() {
	        User u = new User(new Long(5),"eryssi", "erayssi", "ROLE_USER", true);

	        when(this.userRepository.findById(anyLong())).thenReturn(java.util.Optional.of(u));
	        assertEquals(5, u.getId());
	        assertSame(this.userService.getUserById(u.getId()).getId(),u.getId(),
	                "Test failed: Not matching user ID");
	    }

	    @Test
	    public void getAllUsersTest() {
	        List<User> u = new ArrayList<>();
	        u.add(new User(new Long(1),"admin", "admin", "ROLE_ADMIN,ROLE_USER", true));
	        u.add(new User(new Long(3),"eya", "eya", "ROLE_USER", true));
	        u.add(new User(new Long(4),"noor", "noor", "ROLE_ADMIN", true));
	        u.add(new User(new Long(5),"eayssi", "erayssi", "ROLE_USER", true));

	        when(this.userRepository.findAll()).thenReturn(u);
	        assertTrue(this.userService.getAllUsers().size() == u.size(),
	                "Test failed: Size of list isn't equal to the size of the present test");
	    }

	    @Test
	    public void addUserTest() throws Exception {
	        User u = new User("erayssi", "erayssi", "ROLE_USER", true);
	        userService.addUser(u);
	        verify(userRepository, times(1)).save(u);
	    }

	    @Test
	    public void addAdminTest() throws Exception {

	        User u = new User("erayssi", "erayssi", "ROLE_ADMIN", true);
	        userService.addAdmin(u);
	        verify(userRepository, times(1)).save(u);
	    }

	    @Test
	    public void deleteUserTest() {
	        userService.deleteUser(new Long(5));
	        verify(userRepository, times(1)).deleteById(new Long(5));
	    }
	}