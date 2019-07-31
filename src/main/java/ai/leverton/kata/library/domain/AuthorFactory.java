package ai.leverton.kata.library.domain;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class AuthorFactory implements Factory<Author> {

    private final List<BiConsumer<Author.Builder, String[]>> factories;

    private static String[] checkSplitSize(@NonNull String[] split) {
        if (split.length != 3) {
            throw new IllegalArgumentException("there should be 3 values");
        }
        return split;
    }

    private static BiConsumer<Author.Builder, String[]> factoryOf(@NonNull String name, final int pos) {
        //@formatter:off
        switch (name) {
            case     "email": return (authorBuilder, valueLineSplit) -> authorBuilder.email(valueLineSplit[pos]);
            case "firstName": return (authorBuilder, valueLineSplit) -> authorBuilder.firstName(valueLineSplit[pos]);
            case  "lastName": return (authorBuilder, valueLineSplit) -> authorBuilder.lastName(valueLineSplit[pos]);
        }
        //@formatter:on
        return (authorBuilder, strings) -> {};
    }

    @Nonnull
    static AuthorFactory ofCsvHeader(@NonNull String line) {
        final String[] split = checkSplitSize(line.split(";"));
        final List<BiConsumer<Author.Builder, String[]>> factories = new ArrayList<>(3);
        for (int i = 0; i < split.length; i++) {
            factories.add(factoryOf(split[i], i));
        }
        return new AuthorFactory(factories);
    }

    @Nonnull
    public Author create(@NonNull String line) {
        final String[] split = checkSplitSize(line.split(";"));
        final Author.Builder builder = Author.builder();
        factories.forEach(factory -> factory.accept(builder, split));
        return builder.build();
    }
}
