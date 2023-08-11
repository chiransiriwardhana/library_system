package com.librarySystem.RestAPI.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.librarySystem.RestAPI.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByTitle(String title);

//	List<Book> findByAuthorAndTitle(String author, String title);
//
//	List<Book> findByTitleAndAuthor(String title, String author);

//	List<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
}
