package com.citi.restapi.model;

import jakarta.persistence.*;

/**
 * UserModel
 *
 * Based on the data structure
 *
 * CREATE TABLE `User` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `title` varchar(10) DEFAULT NULL,
 *   `first` varchar(50) DEFAULT NULL,
 *   `last` varchar(50) DEFAULT NULL,
 *   `city` varchar(50) DEFAULT NULL,
 *   `state` varchar(50) DEFAULT NULL,
 *   `email` varchar(50) DEFAULT NULL,
 *   `phone` varchar(50) DEFAULT NULL,
 *   `picture` varchar(255) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * )
 *
 * create the attributes for the UserModel and add  the @Column annotation to map the attributes to the columns in the database
 */
@Entity
@Table(name = "User")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "first")
    private String first;
    @Column(name = "last")
    private String last;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "picture")
    private String picture;

    public UserModel() {
    }

    public UserModel(int id, String title, String first, String last, String city, String state, String email, String phone, String picture) {
        this.id = id;
        this.title = title;
        this.first = first;
        this.last = last;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

}
