package com.ingryd.MiniLibraryManagementSystem.model;

import jakarta.persistence.*;

public class BorrowedBooks {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
}
