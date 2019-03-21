package ai.leverton.kata.library.domain;

import lombok.Builder;
import lombok.NonNull;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiConsumer;

@Builder
class BookFactory implements Factory<Book> {

    private final List<BiConsumer<Book.BookBuilder, String[]>> factories;

    private static String[] checkSplitSize(@NonNull String[] split) {
        if (split.length != 4) {
            throw new IllegalArgumentException("there should be 4 values");
        }
        return split;
    }

    private static BiConsumer<Book.BookBuilder, String[]> factoryOf(@NonNull String name, final int pos) {
        switch (name) {
            case "title": return (builder, valueLineSplit) -> builder.title(valueLineSplit[pos]);
            case "description": return (builder, valueLineSplit) -> builder.description(valueLineSplit[pos]);
            case "authors": return (builder, valueLineSplit) -> builder.authors(new HashSet<>(Arrays.asList(valueLineSplit[pos].split(","))));
            case "isbn": return (builder, valueLineSplit) -> builder.isbn(valueLineSplit[pos]);
        }
        return (authorBuilder, strings) -> {};
    }

    @Nonnull
    static BookFactory ofCsvHeader(@NonNull String line) {
        final String[]                                     split     = checkSplitSize(line.split(";"));
        final List<BiConsumer<Book.BookBuilder, String[]>> factories = new ArrayList<>(4);
        for (int i = 0; i < split.length; i++) {
            factories.add(factoryOf(split[i], i));
        }
        return new BookFactory(factories);
    }

    @Override
    public Book create(String line) {
        final String[] split = line.split(";");
        if (split.length != 4) {
            throw new IllegalArgumentException("there should be 3 values");
        }
        final Book.BookBuilder builder = Book.builder();
        factories.forEach(factory -> factory.accept(builder, split));
        return builder.build();
    }
}
