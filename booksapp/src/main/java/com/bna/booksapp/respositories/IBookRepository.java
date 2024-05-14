package com.bna.booksapp.respositories;

import com.bna.booksapp.dtos.BookDto;

import java.util.List;

public interface IBookRepository {
    public List<BookDto> findAll();

    public  BookDto findById(long id);

    public  BookDto create(BookDto book);

    public BookDto update(BookDto book);

    public BookDto delete(long id);
}
