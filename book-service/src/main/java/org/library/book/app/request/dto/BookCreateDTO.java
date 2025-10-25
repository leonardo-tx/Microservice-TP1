package org.library.book.app.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDTO {
    private String isbn;
    private String title;
    private String author;
    private int count;
}
