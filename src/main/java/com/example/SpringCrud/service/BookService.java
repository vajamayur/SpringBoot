package com.example.SpringCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringCrud.entity.Book;
import com.example.SpringCrud.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book book) {

        Book existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(book.getName());
            existing.setAuthor(book.getAuthor());
            existing.setPrice(book.getPrice());

            return repository.save(existing);
        }

        return null;
    }

    public String deleteBook(Long id) {

        repository.deleteById(id);
        return "Book Deleted Successfully";
    }
}   