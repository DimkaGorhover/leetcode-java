package ai.leverton.kata.library.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Book implements Readable {

    String title;
    String description;
    Set<String> authors;
    String isbn;
}
