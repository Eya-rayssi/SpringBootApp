package com.example.BookStoreVermeg.repository;

import java.util.List;
import java.util.Optional;

import com.example.BookStoreVermeg.entity.User;

public interface UserRepository extends JpaRepository {
	public Optional<User> getUserByUserName(String userName);

    public List<User> getUsersByRoles(String role);
}


