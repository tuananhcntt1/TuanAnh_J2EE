package com.example.demoweb.controller;

import com.example.demoweb.model.Book;
import com.example.demoweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET /api/books - Lấy danh sách tất cả sách
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    // GET /api/books/{id} - Lấy sách theo ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // POST /api/books - Thêm sách mới
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // PUT /api/books/{id} - Cập nhật thông tin sách
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // DELETE /api/books/{id} - Xóa sách theo ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return "Book deleted successfully!";
        }
        return "Book not found!";
    }
}
