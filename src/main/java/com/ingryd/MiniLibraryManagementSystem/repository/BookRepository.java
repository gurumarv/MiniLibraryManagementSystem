package com.ingryd.MiniLibraryManagementSystem.repository;

import com.ingryd.MiniLibraryManagementSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
