package com.bna.booksapp.services;

import com.bna.booksapp.dtos.BookDto;
import com.bna.booksapp.respositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> getBooks() {
        return bookRepository.findAll();
    }
}
