package com.bna.booksapp.mappers;

import com.bna.booksapp.dtos.BookDto;
import com.bna.booksapp.entities.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookDto bookDto);

    BookDto toBookDto(Book book);

    List<BookDto> booksDtos(List<Book> books);
}
