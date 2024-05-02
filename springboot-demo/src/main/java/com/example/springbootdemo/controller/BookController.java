package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springbootdemo.model.Book;
import com.example.springbootdemo.service.BookService;

import java.util.List;

/*
 * This class is used to handle HTTP requests related to books.
 * It is annotated with @RestController to indicate that it is a controller class.
 * It is annotated with @RequestMapping to specify the base URL for the controller.
 * It has methods:
 * - getBooks() - This method is used to get all the books from the database.
 * - getBook() - This method is used to get a book by its id from the database.
 * - createBook() - This method is used to create a new book in the database.
 * - updateBook() - This method is used to update a book by its id in the database.
 * - deleteBook() - This method is used to delete a book by its id from the database.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        return bookService.getBook(id);
    }

    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        return bookService.updateBookById(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") int id) {
        return bookService.deleteBook(id);
    }

}
