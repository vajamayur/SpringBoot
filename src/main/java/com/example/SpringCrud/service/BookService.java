package com.example.SpringCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringCrud.entity.Book;
import com.example.SpringCrud.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Get All Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
    return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
    return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book book) {

    Book b = bookRepository.findById(id).orElse(null);

    if (b != null) {
        b.setName(book.getName());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());

        return bookRepository.save(b);
    }

        return null;
    }
}