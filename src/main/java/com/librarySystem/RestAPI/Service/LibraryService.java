package com.librarySystem.RestAPI.Service;

import com.librarySystem.RestAPI.dto.ResponseMessageBody;
import com.librarySystem.RestAPI.model.Book;
import com.librarySystem.RestAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryService {

    List<Book> getAllBooks();

    ResponseMessageBody addBook(Book book);

    public Book searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    ResponseMessageBody loanBook(String title, User user);

    ResponseMessageBody returnBook(User user, String title);

}
