package lu.eyet.dev.jdbcsandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.eyet.dev.jdbcsandbox.model.Book;
import lu.eyet.dev.jdbcsandbox.repository.BookRepository;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path = "books")
    public Page<Book> getBooks(Pageable page) {
        return bookRepository.findAll(page);
    }

}