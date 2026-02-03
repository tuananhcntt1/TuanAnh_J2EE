package com.example.demoweb.service;

import com.example.demoweb.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    // Constructor khởi tạo dữ liệu mẫu
    public BookService() {
        books.add(new Book(1, "Spring Boot in Action", "Craig Walls"));
        books.add(new Book(2, "Java Programming", "John Smith"));
        books.add(new Book(3, "Clean Code", "Robert Martin"));
    }

    // Lấy tất cả sách
    public List<Book> getBooks() {
        return books;
    }

    // Lấy sách theo ID
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm sách mới
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // Cập nhật sách
    public Book updateBook(int id, Book updatedBook) {
        Book book = getBookById(id);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return book;
        }
        return null;
    }

    // Xóa sách
    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}

