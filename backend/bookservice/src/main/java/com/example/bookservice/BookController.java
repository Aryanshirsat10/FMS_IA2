package com.example.bookservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    // @GetMapping
    // public List<Book> getAllBooks() {
    //     return bookRepository.findAll();
    // }

    // @GetMapping("/{id}")
    // public Book getBookById(@PathVariable String id) {
    //     return bookRepository.findById(id).orElse(null);
    // }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<List<Book>>(bookService.allBooks(), HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<Optional<Book>> getSingleBook(@RequestBody BookIdDTO bookIdDTO) {
        ObjectId id = new ObjectId(bookIdDTO.getId());
        return new ResponseEntity<Optional<Book>>(bookService.findBookById(id), HttpStatus.OK);
    }
    // In BookController.java

    // @PutMapping("/{bookId}/quantity")
    // public ResponseEntity<Book> updateBookQuantity(@PathVariable ObjectId bookId, @RequestBody Integer quantity) {
    //     Optional<Book> optionalBook = bookService.findBookById(bookId);
    //     if (optionalBook.isPresent()) {
    //         Book book = optionalBook.get();
    //         book.setQuantity(quantity);
    //         Book updatedBook = bookService.saveBook(book);
    //         return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }
    
    @PutMapping("/{bookId}/quantity")
    public ResponseEntity<Book> updateBookQuantity(@PathVariable ObjectId bookId, @RequestBody Integer quantity) {
        bookService.updateBookQuantity(bookId, quantity);
        return ResponseEntity.ok().build();
    }



}
