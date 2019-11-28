package ru.lofitsky.training.book_store_example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.lofitsky.training.book_store_example.model.Book;
import ru.lofitsky.training.book_store_example.repository.BookRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenFindByTitle_thenReturnBook() {
        // given
        Book testBook = new Book("The Holy Bible");
        entityManager.persist(testBook);
        entityManager.flush();

        // when
        Book found = bookRepository.findByTitle(testBook.getTitle());

        // then
        assertThat(found.getTitle()).isEqualTo(testBook.getTitle());
    }
}