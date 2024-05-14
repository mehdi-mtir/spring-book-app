package com.bna.booksapp.respositories;

import com.bna.booksapp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
