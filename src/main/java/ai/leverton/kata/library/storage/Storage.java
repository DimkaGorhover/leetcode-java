package ai.leverton.kata.library.storage;

import ai.leverton.kata.library.domain.Author;
import ai.leverton.kata.library.domain.Book;
import ai.leverton.kata.library.domain.Magazine;

import java.util.List;

public interface Storage {

    void storeAuthors(List<Author> authors);

    void storeBooks(List<Book> authors);

    void storeMagazines(List<Magazine> authors);

    /**
     * Task 1
     */
    void printBooksAndMagazinesVerbose();
}
