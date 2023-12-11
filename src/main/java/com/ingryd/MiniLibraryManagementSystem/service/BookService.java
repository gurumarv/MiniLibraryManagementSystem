package com.ingryd.MiniLibraryManagementSystem.service;

import com.ingryd.MiniLibraryManagementSystem.model.Book;
import com.ingryd.MiniLibraryManagementSystem.model.User;
import com.ingryd.MiniLibraryManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book saveUser(Book book){
        return bookRepository.save(book);
    }
    public ResponseEntity<Book> findBookById(int id){
        return ResponseEntity.ok(bookRepository.findById(id).orElse(null));
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
    public String deleteBook(int id){
        bookRepository.deleteById(id);
        return "Deleted Successfully";
    }
    public Book updateBook(int id, Book book){
        Book bookUpdate = bookRepository.findById(id).orElse(null);
        assert bookUpdate != null;
        bookUpdate.setTitle(book.getTitle());
        bookUpdate.setAuthor(book.getAuthor());
        bookUpdate.setIsbn(book.getIsbn());
        bookUpdate.setPublicationYear(book.getPublicationYear());
        return bookRepository.save(bookUpdate);
    }


}
