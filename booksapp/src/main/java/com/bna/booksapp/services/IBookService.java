package com.bna.booksapp.services;

import com.bna.booksapp.dtos.BookDto;

import java.util.List;

public interface IBookService {
    public List<BookDto> getBooks();


    public BookDto getBookById(long id);

    public BookDto addBook(BookDto book);

    public BookDto updateBook(long id, BookDto book);

    public BookDto deleteBook(long id);

}
