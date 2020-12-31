package com.example.BookStoreVermeg.controller;

import com.example.BookStoreVermeg.entity.User;
import com.example.BookStoreVermeg.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import com.example.BookStoreVermeg.controller.UserController;

public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	UserService userService;
	@InjectMocks
	UserController userController;
	
	public static void beforeAll() {
        System.out.println("Start testing the user controller");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("End testing the user controller");
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
    public void getAllUsersTest() throws Exception {

        List<User> users = new ArrayList<User>();

        when(userService.getAllUsers()).thenReturn(users);

        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url+"users"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserByIdTest() throws Exception {

        User u = new User(new Long(5),"erayssi", "erayssi", "ROLE_USER", true);

        when(userService.getUserById(anyLong())).thenReturn(u);

        mockMvc.perform(MockMvcRequestBuilders.get(this.url+"user/5")).andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(u.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value(u.getUserName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roles").value(u.getRoles()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.active").value(u.isActive()))
                .andExpect(status().isOk());
    }

    @Test
    public void addUserTest() throws Exception {
        User u = new User("erayssi", "erayssi", "ROLE_USER", true);

        when(userService.addUser(any(User.class))).thenReturn(u);

        mockMvc.perform(MockMvcRequestBuilders.post(url+"user/add")
                .content(new ObjectMapper().writeValueAsString(u))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void addAdminTest() throws Exception {
        User u = new User("njeddi", "njeddi", "ROLE_ADMIN", true);

        when(userService.addAdmin(any(User.class))).thenReturn(u);

        mockMvc.perform(MockMvcRequestBuilders.post(url+"admin/add")
                .content(new ObjectMapper().writeValueAsString(u))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void deleteUserTest() throws Exception {
        User u = new User();

        when(userService.deleteUser(anyLong())).thenReturn(u);

        mockMvc.perform(MockMvcRequestBuilders.delete(url+"user/3/delete")
                .content(new ObjectMapper().writeValueAsString(u))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }
}