package com.greetingapp.greetpeople.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
@Entity
@Table(name = "users")
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean isVerified;
    private String verificationToken;

    public AuthUser() {
        // Default constructor
    }


    public AuthUser(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = encryptPassword(password);
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName= firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password=password;
    }


    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }
}




//public class AuthUser {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String firstName;
//
//    @Column(nullable = false)
//    private String lastName;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    public AuthUser() {}
//
//    public AuthUser(String firstName, String lastName, String email, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = encryptPassword(password);
//    }
//
//    private String encryptPassword(String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.encode(password);
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        this.password = encoder.encode(password);
//    }
//}
