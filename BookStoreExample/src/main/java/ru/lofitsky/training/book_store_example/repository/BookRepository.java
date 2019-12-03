package ru.lofitsky.training.book_store_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lofitsky.training.book_store_example.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);
}