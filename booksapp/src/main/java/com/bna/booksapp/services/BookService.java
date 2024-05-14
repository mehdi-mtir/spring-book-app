package com.bna.booksapp.services;

import com.bna.booksapp.dtos.BookDto;
import com.bna.booksapp.entities.Book;
import com.bna.booksapp.mappers.BookMapper;
import com.bna.booksapp.respositories.BookJpaRepository;
//import com.bna.booksapp.respositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    BookJpaRepository bookRepository;
    BookMapper bookMapper;

    public BookService(BookJpaRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.booksDtos(books);
    }


    @Override
    public BookDto getBookById(long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return bookMapper.toBookDto(book);
    }


    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = bookRepository.save(bookMapper.toBook(bookDto));
        return bookMapper.toBookDto(book);
    }


    @Override
    public BookDto updateBook(long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElse(null);
        bookDto.setId(book.getId());
        bookRepository.save(bookMapper.toBook(bookDto));
        return bookMapper.toBookDto(book);
    }

    @Override
    public BookDto deleteBook(long id) {
        Book book = bookRepository.findById(id).orElse(null);
        bookRepository.deleteById(id);
        return bookMapper.toBookDto(book);
    }
}
