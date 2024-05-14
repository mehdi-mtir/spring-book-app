package com.bna.booksapp.mappers;

import com.bna.booksapp.dtos.BookDto;
import com.bna.booksapp.entities.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-14T12:21:32+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setAuthor( bookDto.getAuthor() );
        book.setPrice( bookDto.getPrice() );
        book.setCover( bookDto.getCover() );
        book.setDescription( bookDto.getDescription() );

        return book;
    }

    @Override
    public BookDto toBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        long id = 0L;
        String title = null;
        String author = null;
        double price = 0.0d;
        String cover = null;
        String description = null;

        if ( book.getId() != null ) {
            id = book.getId();
        }
        title = book.getTitle();
        author = book.getAuthor();
        price = book.getPrice();
        cover = book.getCover();
        description = book.getDescription();

        BookDto bookDto = new BookDto( id, title, author, price, cover, description );

        return bookDto;
    }

    @Override
    public List<BookDto> booksDtos(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( books.size() );
        for ( Book book : books ) {
            list.add( toBookDto( book ) );
        }

        return list;
    }
}
