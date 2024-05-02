package com.example.springbootdemo.model;

import jakarta.persistence.*;
import lombok.*;

/*
 * This class is used to represent a book entity in the database.
 * It is annotated with @Entity to indicate that it is an entity class.
 * It is annotated with @Table to specify the name of the table in the database.
 * It has fields:
 * - id: An integer field to store the id of the book.
 * - title: A string field to store the title of the book.
 * - author: A string field to store the author of the book.
 * - price: A double field to store the price of the book.
 */
@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private double price;

}
