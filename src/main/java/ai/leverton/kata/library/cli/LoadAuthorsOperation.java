package ai.leverton.kata.library.cli;

import ai.leverton.kata.library.domain.Author;
import ai.leverton.kata.library.storage.Storage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class LoadAuthorsOperation implements Operation {

    private final File    file;
    private final Storage storage;

    @lombok.Builder(builderClassName = "Builder", toBuilder = true)
    private LoadAuthorsOperation(File file, Storage storage) {
        this.file = file;
        this.storage = storage;
    }

    @Override
    public void proceed() {

        try {

            List<Author> collect = StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                    CSVParser.parse(new FileReader(file), CSVFormat.DEFAULT.withDelimiter(';')).iterator(),
                    0), false)
                    .map(Author::of)
                    .collect(Collectors.toList());

            storage.storeAuthors(collect);

        } catch (IOException e) {
            throw new CliException(e);
        }
    }
}
