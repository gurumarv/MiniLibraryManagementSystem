package com.ingryd.MiniLibraryManagementSystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "borrowed_books")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @JoinColumn(name = "book_title", referencedColumnName = "title")
    @JoinColumn(name = "book_author", referencedColumnName = "author")
    private Book book;


    public BorrowedBook() {
    }

    public BorrowedBook(User userId, Book book) {
        this.userId = userId;
        this.book = book;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @Override
    public String toString() {
        return "BorrowedBook{" +
                "id=" + id +
                ", userId=" + userId +
                ", book=" + book +
                '}';
    }
}
