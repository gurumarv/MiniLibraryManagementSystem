package com.ingryd.MiniLibraryManagementSystem.repository;

import com.ingryd.MiniLibraryManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
