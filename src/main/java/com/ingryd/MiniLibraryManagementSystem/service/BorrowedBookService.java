package com.ingryd.MiniLibraryManagementSystem.service;


import com.ingryd.MiniLibraryManagementSystem.model.Book;
import com.ingryd.MiniLibraryManagementSystem.model.BorrowedBook;

import com.ingryd.MiniLibraryManagementSystem.model.User;
import com.ingryd.MiniLibraryManagementSystem.repository.BookRepository;
import com.ingryd.MiniLibraryManagementSystem.repository.BorrowedBookRepository;
import com.ingryd.MiniLibraryManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookService {
    @Autowired
    BorrowedBookRepository borrowedBookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<BorrowedBook> saveBorrowedBook(Integer bookId, Integer userId){
        BorrowedBook borrowedBook = new BorrowedBook();
        Book book = bookRepository.findById(bookId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        borrowedBook.setBook(book);
        borrowedBook.setUserId(user);
        return ResponseEntity.ok(borrowedBookRepository.save(borrowedBook));
    }
    public ResponseEntity<BorrowedBook> findBorrowedBookById(int id){
        return ResponseEntity.ok(borrowedBookRepository.findById(id).orElse(null));
    }

    public List<BorrowedBook> findAllBorrowedBooks(){
        return borrowedBookRepository.findAll();
    }
    public String deleteBorrowedBook(int id){
        borrowedBookRepository.deleteById(id);
        return "Deleted Successfully";
    }
    public BorrowedBook updateBorrowedBook(Integer id, Integer userId, Integer bookId){
        BorrowedBook borrowedBookUpdate = borrowedBookRepository.findById(id).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        assert borrowedBookUpdate != null;
        borrowedBookUpdate.setBook(book);
        borrowedBookUpdate.setUserId(user);
        return borrowedBookRepository.save(borrowedBookUpdate);
    }

}
