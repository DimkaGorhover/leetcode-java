package ai.leverton.kata.library.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Book implements Readable {

    private final String      title;
    private final String      description;
    private final Set<String> authors;
    private final String      isbn;
}
