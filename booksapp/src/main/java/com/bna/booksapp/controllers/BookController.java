package com.bna.booksapp.controllers;

import com.bna.booksapp.dtos.BookDto;
import com.bna.booksapp.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<String> getBookById(){
        return ResponseEntity.ok("OK");
    }
}
