package com.ingryd.MiniLibraryManagementSystem.controller;

import com.ingryd.MiniLibraryManagementSystem.model.BorrowedBook;
import com.ingryd.MiniLibraryManagementSystem.model.User;
import com.ingryd.MiniLibraryManagementSystem.service.BorrowedBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BorrowedBookController {
    @Autowired
    BorrowedBookService borrowedBookService;
    @GetMapping("/borrowedbook/{id}")
    public BorrowedBook findBorrowedBookById(@PathVariable int id){
        return borrowedBookService.findBorrowedBookById(id).getBody();
    }
    @GetMapping("/borrowedbook/all")
    public List<BorrowedBook> findAllBorrowedBook(){
        return borrowedBookService.findAllBorrowedBooks();
    }
    @PostMapping("/borrowedbook/{bookId}/{userId}")
    public ResponseEntity<BorrowedBook> postBorrowedBook(@Valid @PathVariable("bookId") Integer bookId, @PathVariable("userId") Integer userId){
        return borrowedBookService.saveBorrowedBook(userId, bookId);
    }
    @PutMapping("/borrowedbook/{id}/{userId}/{bookId}")
    public BorrowedBook updateBorrowedBookById(@PathVariable("id") Integer id, @PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId){
        return borrowedBookService.updateBorrowedBook(id, userId, bookId);
    }
    @DeleteMapping("/deleteborrowedbook/{id}")
    public String deleteBorrowedBookById(@PathVariable int id){
        return borrowedBookService.deleteBorrowedBook(id);
    }
}
