package org.library.book.app.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookViewDTO {
    private String isbn;
    private String title;
    private String author;
    private int count;
}
