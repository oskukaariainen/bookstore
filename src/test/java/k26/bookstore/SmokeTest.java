package k26.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import k26.bookstore.web.BookController;
import k26.bookstore.web.RestBookController;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private RestBookController restBookController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(bookController).isNotNull();
        assertThat(restBookController).isNotNull();
    }

}
