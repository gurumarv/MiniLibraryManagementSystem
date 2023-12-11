package com.ingryd.MiniLibraryManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user")
public class Users {
    @NotNull(message = "Full name cannot be Null")
    @NotBlank(message = "Full name cannot be blank")
    @Column(name = "full_name")
    @Length(min = 6, max = 15, message = "Full name too short/long")
    private String fullName;
    @Min(value = 18)
    @Max(value = 70)
    @NotNull(message = "Age cannot be null")
    private int age;
    @Email
    private String email;
    @NotNull(message = "Address cannot be Null")
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    public Users() {
    }

    public Users(String fullName, int age, String email, String address) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
