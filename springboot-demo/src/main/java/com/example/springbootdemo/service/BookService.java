package com.example.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.springbootdemo.model.Book;
import com.example.springbootdemo.repository.BookRepository;

import java.util.List;

/*
 * This class is used to implement the business logic of the application.
 * It is used to interact with the repository layer and perform CRUD operations on the database.
 * getBooks() - This method is used to get all the books from the database.
 * getBook() - This method is used to get a book by its id from the database.
 * createBook() - This method is used to create a new book in the database.
 * updateBookById() - This method is used to update a book by its id in the database.
 * deleteBook() - This method is used to delete a book by its id from the database.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<List<Book>> getBooks() {
        try {
            List<Book> books = bookRepository.findAll();

            if (books.isEmpty()) {
                return new ResponseEntity<>(books, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Book> getBook(int id) {
        try {
            Book book = bookRepository.findById(id).get();
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Book> createBook(Book book) {
        try {
            Book _book = bookRepository.save(book);
            return new ResponseEntity<>(_book, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Book> updateBookById(int id, Book book) {
        try {
            Book existingBook = bookRepository.findById(id).get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            Book updatedBook = bookRepository.save(existingBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteBook(int id) {
        try {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
