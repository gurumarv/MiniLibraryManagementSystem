package com.ingryd.MiniLibraryManagementSystem.repository;

import com.ingryd.MiniLibraryManagementSystem.model.Book;
import com.ingryd.MiniLibraryManagementSystem.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {
}
