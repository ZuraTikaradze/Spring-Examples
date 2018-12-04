package ge.edu.cu.demo.controller;

import ge.edu.cu.demo.model.Book;
import ge.edu.cu.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/caching/
//
@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        return bookRepository.getByIsbn(isbn);
    }
}
