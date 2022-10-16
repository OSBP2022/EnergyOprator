package org.example;


import org.example.module.BookDto;
import org.example.ports.api.BookServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/book")
public class BookRestApi {

  @Autowired
  private BookServicePort bookServicePort;

  private Logger logger = LoggerFactory.getLogger(BookRestApi.class);


  @PostMapping ("/add")
  public BookDto addBook(@RequestBody BookDto bookDto) {
    logger.info("Add book=> "+bookDto);
    return bookServicePort.addBook(bookDto);
  }

  @PutMapping("/update")
  public BookDto updateBook(@RequestBody BookDto bookDto) {
    return bookServicePort.updateBook(bookDto);
  }

  @GetMapping("/get/{id}")
  public BookDto getBookByID(@PathVariable long id) {
    return bookServicePort.getBookById(id);
  }

  @GetMapping("/get")
  public List<BookDto> getAllBooks() {
    return bookServicePort.getBooks();
  }

  @DeleteMapping("/delete/{id}")
  public void deleteBookByID(@PathVariable long id) {
    bookServicePort.deleteBookById(id);
  }
}
