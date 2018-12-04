package ge.edu.cu.demo.repository;

import ge.edu.cu.demo.config.CacheConfig;
import ge.edu.cu.demo.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;



@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable(CacheConfig.CACHE_TWO)
    public Book getByIsbn(String isbn) {
        System.out.println("shemovedi************");
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}