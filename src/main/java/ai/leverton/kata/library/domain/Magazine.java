package ai.leverton.kata.library.domain;

import lombok.Value;

import java.util.Set;

@Value
public class Magazine implements Readable {

    private final String      title;
    private final Set<String> authors;
    private final long        publishedAt;
    private final String      isbn;
}
