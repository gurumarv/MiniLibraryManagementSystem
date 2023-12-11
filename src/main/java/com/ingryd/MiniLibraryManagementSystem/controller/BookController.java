package com.ingryd.MiniLibraryManagementSystem.controller;

import com.ingryd.MiniLibraryManagementSystem.model.Book;
import com.ingryd.MiniLibraryManagementSystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/book/{id}")
    public Book findBookById(@PathVariable int id){
        return bookService.findBookById(id).getBody();
    }
    @GetMapping("/book/all")
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }
    @PostMapping("/book")
    public Book postBook(@RequestBody @Valid Book book){
        return bookService.saveUser(book);
    }
    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody @Valid Book book){
        return bookService.updateBook(id, book);
    }
    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id){
        return bookService.deleteBook(id);
    }
}
