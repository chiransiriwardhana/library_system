package com.librarySystem.RestAPI.Service.impl;

import com.librarySystem.RestAPI.Repository.BookRepository;
import com.librarySystem.RestAPI.Repository.UserRepository;
import com.librarySystem.RestAPI.Service.LibraryService;
import com.librarySystem.RestAPI.dto.ResponseMessageBody;
import com.librarySystem.RestAPI.model.Book;
import com.librarySystem.RestAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public ResponseMessageBody addBook(Book book) {

        Book existingBook;
        try {
            existingBook = bookRepository.findByTitle(book.getTitle());
            int availability = existingBook.getStock();
            existingBook.setStock(availability+book.getStock());
            Book bookObject = bookRepository.save(existingBook);

            return new ResponseMessageBody(bookObject);
        }catch (Exception e){
            Book bookObject = (Book) bookRepository.save(book);
            return new ResponseMessageBody(bookObject);
        }
    }

    public Book searchByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> searchByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public ResponseMessageBody loanBook(String title, User user) {
        Book book;
        User existingUser;

        book = bookRepository.findByTitle(title);
        if(book == null){
            return new ResponseMessageBody("Book is not found. | Book Name : "+title);
        }

        try{
            existingUser = userRepository.findByName(user.getName());

            if(existingUser.getBookName() != null){
                return new ResponseMessageBody("User already borrowed a book.");
            }
        }catch (Exception e){
            return new ResponseMessageBody("User is not registered in library. Please register.");
        }

        if (book.getStock() < 1) {
            return null;
        }
        book.setStock(book.getStock() - 1);

        Date currentDate = new Date();
        existingUser.setBorrowedDate(currentDate);

        if (user.getReturnedDate() != null){
            existingUser.setReturnedDate(user.getReturnedDate());
        }else {
            existingUser.setReturnedDate(getDateBAfterTwoWeeks(currentDate));
        }
        existingUser.setBookName(book.getTitle());

        userRepository.save(existingUser);
        bookRepository.save(book);

        return new ResponseMessageBody(user);

    }

    private Date getDateBAfterTwoWeeks(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +14); //2 weeks
        return calendar.getTime();
    }

    public ResponseMessageBody returnBook(User user, String title) {

        Book existingBook;
        User existingUser;

        try{
            existingUser = userRepository.findByName(user.getName());

            if(existingUser.getBookName() == null){
                return new ResponseMessageBody("User not borrowed a book.");
            }
        }catch (Exception e){
            return new ResponseMessageBody("User is not registered in library. Please register.");
        }

        existingBook = bookRepository.findByTitle(title);
        if(existingBook == null){
            return new ResponseMessageBody("Book is not found. | Book Name : "+title);
        }

        existingUser.setBookName(null);
        existingUser.setBorrowedDate(null);
        existingUser.setReturnedDate(null);

        existingBook.setStock(existingBook.getStock()+1);

        userRepository.save(existingUser);
        bookRepository.save(existingBook);

        return new ResponseMessageBody(existingUser.getName() + " successfully return the book. Book name : "+title);

    }
}
