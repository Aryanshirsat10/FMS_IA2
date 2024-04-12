package com.example.bookservice;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> allBooks(){
        return bookRepository.findAll();
    }
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public Optional<Book> findBookById(ObjectId id) {
        return bookRepository.findBookById(id);
    }
    public void updateBookQuantity(ObjectId bookId, int quantity) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setQuantity(quantity);
            bookRepository.save(book);
        } else {
            // handle the case where the book is not found
        }
    }
}
