package ai.leverton.kata.library.cli;

import ai.leverton.kata.library.domain.DomainObjectType;
import ai.leverton.kata.library.storage.Storage;
import lombok.NonNull;

import java.io.File;

class EnterLoadPathOperation implements Operation {

    private final Printer          out;
    private final Reader           reader;
    private final DomainObjectType domainObjectType;
    private final Storage          storage;

    @lombok.Builder(builderClassName = "Builder", toBuilder = true)
    private EnterLoadPathOperation(@NonNull Printer out,
                                   @NonNull Reader reader,
                                   @NonNull DomainObjectType domainObjectType,
                                   @NonNull Storage storage) {
        this.out = out;
        this.reader = reader;
        this.domainObjectType = domainObjectType;
        this.storage = storage;
    }

    @Override
    public void proceed() {
        String message = "" +
                "----------------------------------------\n" +
                "write full path to file: ";

        int code = -1;
        while (code != 0) {

            out.print(message);

            final String fileName = reader.read();
            if (fileName == null || fileName.isEmpty()) {
                out.println("file path cannot be null or empty");
                continue;
            }

            final File file = new File(fileName);
            if (!file.exists() || !file.isFile()) {
                out.println("file \"" + fileName + "\" doesn't exist or it's not file at all");
                continue;
            }

            switch (domainObjectType) {

                case AUTHOR: {

                    LoadAuthorsOperation.builder()
                            .file(file)
                            .storage(storage)
                            .build()
                            .proceed();

                    break;
                }
                case BOOK: {
                    throw new UnsupportedOperationException();
                }
                case MAGAZINE: {
                    throw new UnsupportedOperationException();
                }
                default: {
                    throw new UnsupportedOperationException();
                }
            }
            code = 0;
        }
    }
}
