package org.library.book.app.controller;

import lombok.RequiredArgsConstructor;
import org.library.book.app.request.dto.BookCreateDTO;
import org.library.book.app.request.dto.BookLoanCreateDTO;
import org.library.book.app.request.dto.BookUpdateDTO;
import org.library.book.app.request.mapper.BookCreateMapper;
import org.library.book.app.request.mapper.BookUpdateMapper;
import org.library.book.app.response.dto.ApiResponse;
import org.library.book.app.response.dto.BookViewDTO;
import org.library.book.app.response.mapper.BookViewMapper;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookFacade bookFacade;
    private final BookViewMapper bookViewMapper;
    private final BookCreateMapper bookCreateMapper;
    private final BookUpdateMapper bookUpdateMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<BookViewDTO>>> getAllBooks() {
        List<BookViewDTO> booksViews = bookFacade.getAll()
                .stream()
                .map(bookViewMapper::toEntity)
                .toList();
        return ApiResponse.success(booksViews).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<ApiResponse<BookViewDTO>> getBookByIsbn(@PathVariable("isbn") String isbn) {
        Book book = bookFacade.getByIsbn(isbn);
        BookViewDTO bookView = bookViewMapper.toEntity(book);

        return ApiResponse.success(bookView).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookViewDTO>> createBook(@RequestBody BookCreateDTO form) {
        Book book = bookCreateMapper.toModel(form);
        Book createdBook = bookFacade.add(book);
        BookViewDTO createdBookView = bookViewMapper.toEntity(createdBook);

        return ApiResponse.success(createdBookView).createResponse(HttpStatus.CREATED);
    }

    @PostMapping("/{isbn}/loan")
    public ResponseEntity<ApiResponse<UUID>> loanBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookLoanCreateDTO form
    ) {
        UUID loanId = bookFacade.loanByIsbn(isbn, form.getDueDate());
        return ApiResponse.success(loanId).createResponse(HttpStatus.CREATED);
    }

    @PostMapping("/{loanId}/return")
    public ResponseEntity<ApiResponse<Object>> returnBook(@PathVariable("loanId") UUID loanId) {
        bookFacade.returnByLoanId(loanId);
        return ApiResponse.success(null).createResponse(HttpStatus.OK);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<ApiResponse<BookViewDTO>> updateBookByIsbn(
            @PathVariable("isbn") String isbn,
            @RequestBody BookUpdateDTO form
    ) {
        Book book = bookUpdateMapper.toModel(form, isbn);
        Book updatedBook = bookFacade.update(book);
        BookViewDTO updatedBookView = bookViewMapper.toEntity(updatedBook);

        return ApiResponse.success(updatedBookView).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<ApiResponse<Object>> deleteBookByIsbn(@PathVariable("isbn") String isbn) {
        bookFacade.deleteByIsbn(isbn);
        return ApiResponse.success(null).createResponse(HttpStatus.OK);
    }
}
