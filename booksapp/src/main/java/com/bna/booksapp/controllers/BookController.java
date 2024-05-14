package com.bna.booksapp.controllers;

import com.bna.booksapp.dtos.BookDto;
import com.bna.booksapp.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<BookDto> getBookById(@PathVariable long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto book){
        return ResponseEntity.ok(bookService.addBook(book));
    }


    @PutMapping("/books/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable long id, @RequestBody BookDto bookDto){
        System.out.println("controller : " + bookDto.toString());
        return ResponseEntity.ok(bookService.updateBook(id, bookDto));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookDto> deleteBook(@PathVariable long id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }


}
