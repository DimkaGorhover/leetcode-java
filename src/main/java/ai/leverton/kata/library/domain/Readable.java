package ai.leverton.kata.library.domain;

import java.util.Set;

public interface Readable extends Entity {

    String getTitle();

    Set<String> getAuthors();

    String getIsbn();
}
