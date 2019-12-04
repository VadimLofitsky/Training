package ru.lofitsky.training.book_store_example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.lofitsky.training.book_store_example.Application;
import ru.lofitsky.training.book_store_example.model.Book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
class BookRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void givenBooks_whenGetBooks_theStatus200() throws Exception {
        Book testBook = new Book();
        testBook.setTitle("The Holy Bible");

        mvc.perform(get("/")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
}