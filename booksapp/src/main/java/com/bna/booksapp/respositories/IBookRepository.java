package com.bna.booksapp.respositories;

import com.bna.booksapp.dtos.BookDto;

import java.util.List;

public interface IBookRepository {
    public List<BookDto> findAll();
}
