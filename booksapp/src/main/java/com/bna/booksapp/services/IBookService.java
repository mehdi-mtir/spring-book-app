package com.bna.booksapp.services;

import com.bna.booksapp.dtos.BookDto;

import java.util.List;

public interface IBookService {
    public List<BookDto> getBooks();
}
