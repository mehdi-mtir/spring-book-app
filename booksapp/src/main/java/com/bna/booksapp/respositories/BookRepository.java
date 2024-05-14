package com.bna.booksapp.respositories;

import com.bna.booksapp.dtos.BookDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class BookRepository implements IBookRepository {
    private List<BookDto> books;

    {
        books = new ArrayList<>();
        books.add(new BookDto(1, "The slight edge", "Jeff Olsen", 20.5, "https://m.media-amazon.com/images/I/51LydLCdOwL._AC_UF1000,1000_QL80_.jpg", "In this Australian edition, you will read the life-changing concepts of the original book, and learn what author Jeff Olson discovered as he continued along The Slight Edge path: the Secret to Happiness and the Ripple Effect."));
        books.add(new BookDto(2, "Atomic Habits", "James Clear", 25.0, "https://images.epagine.fr/831/9781847941831_1_75.jpg", "The instant New York Times bestseller Financial Times Book of the Month A revolutionary system to get 1 per cent better every day People think when you want to change your life, you need to think big. But world-renowned habits expert James Clear has discovered another way."));
    }

    @Override
    public List<BookDto> findAll() {
        return books;
    }

    @Override
    public BookDto findById(long id) {
        for(BookDto book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    @Override
    public BookDto create(BookDto book) {
        long id = books.getLast().getId() + 1;
        book.setId(id);
        books.add(book);
        return book;
    }

    public BookDto update(BookDto bookUpdated){
        for(int i=0; i<books.size(); i++){
            if(books.get(i).getId() == bookUpdated.getId()){
                books.set(i, bookUpdated);
                //System.out.println(books.get(i).getId());
                //System.out.println(bookUpdated.getId());
                return bookUpdated;
            }
        }
        return null;
    }

    @Override
    public BookDto delete(long id) {
        for(int i=0; i<books.size(); i++){
            if(books.get(i).getId() == id){
                BookDto bookToDelete = books.get(i);
                //System.out.println(books.get(i).getId());
                books.remove(i);
                return bookToDelete;
            }
        }
        return null;
    }


}
