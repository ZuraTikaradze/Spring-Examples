package ge.edu.cu.demo.repository;

import ge.edu.cu.demo.model.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}