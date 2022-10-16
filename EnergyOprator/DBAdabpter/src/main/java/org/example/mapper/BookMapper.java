package org.example.mapper;

import org.example.entity.Book;
import org.example.module.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public class BookMapper {


  public static BookDto bookToBookDto(Book book){
    BookDto bookDto= new BookDto();
    bookDto.setId(book.getId());
    bookDto.setTitle(book.getTitle());
    bookDto.setPrice(book.getPrice());
    bookDto.setDescription(book.getDescription());
    return bookDto;
  }

  public static Book bookDtoToBook(BookDto bookDto){
    Book book= new Book();
    book.setId(bookDto.getId());
    book.setTitle(bookDto.getTitle());
    book.setPrice(bookDto.getPrice());
    book.setDescription(bookDto.getDescription());
    return book;
  }

  public static List<BookDto> bookListToBookDtoList(List<Book> bookList){
    List<BookDto> bookDtoList = new ArrayList<>();
    for (Book book:bookList) {
        bookDtoList.add(bookToBookDto(book));
    }
    return bookDtoList;
  }

  public List<Book> BookDtoListTobookList(List<BookDto> BookDtoList){
    List<Book> bookList = new ArrayList<>();
    for (BookDto bookDto:BookDtoList) {
      bookList.add(bookDtoToBook(bookDto));
    }
    return bookList;
  }
}
