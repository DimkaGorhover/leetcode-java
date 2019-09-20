package ai.leverton.kata.library.storage;

import ai.leverton.kata.library.domain.Author;
import ai.leverton.kata.library.domain.Book;
import ai.leverton.kata.library.domain.Magazine;
import ai.leverton.kata.library.domain.Readable;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCustomStorage implements Storage {

    private final Map<String, Readable>      isbnIndex   = new ConcurrentHashMap<>();
    private final Map<String, Set<Readable>> authorIndex = new ConcurrentHashMap<>();

    private void indexIsbn(Readable readable) {
        if (readable == null) {
            return;
        }
        isbnIndex.compute(readable.getIsbn(), (isbn, prev) -> {
            if (prev == null || Objects.equals(readable, prev)) {
                return readable;
            }
            throw new IllegalStateException("there is more than one book/magazine with the same isbn: \"" + isbn + "\"");
        });
    }

    private void indexAuthor(Readable readable) {
        if (readable == null) {
            return;
        }

        readable.getAuthors().forEach(author -> {

        });


    }

    @Override
    public void storeAuthors(List<Author> authors) {
    }

    @Override
    public void storeBooks(List<Book> books) {
        books.forEach(this::indexIsbn);

    }

    @Override
    public void storeMagazines(List<Magazine> magazines) {
        magazines.forEach(this::indexIsbn);

    }

    @Override
    public void printBooksAndMagazinesVerbose() {

    }
}
