package org.library.book.core.model;

import lombok.Getter;
import org.library.book.core.exception.CoreException;

import java.util.Objects;

@Getter
public final class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private int count;

    public Book(String isbn, String title, String author, int count) {
        this.isbn = Objects.requireNonNull(isbn);
        this.title = Objects.requireNonNull(title);
        this.author = Objects.requireNonNull(author);

        if (count < 0) {
            throw new CoreException("book.count.invalid", "The book count cannot be negative.");
        }
        this.count = count;
    }

    public void decreaseCount() {
        if (count == 0) {
            throw new CoreException("book.count.empty", "There are no more books to subtract.");
        }
        count -= 1;
    }

    public void increaseCount() {
        count += 1;
    }
}
