package ai.leverton.kata.library.cli;

import ai.leverton.kata.library.storage.Storage;
import lombok.NonNull;

public class MainStageOperation implements Operation {

    private final Printer out;
    private final Reader  reader;
    private final Storage storage;

    @lombok.Builder(builderClassName = "Builder", toBuilder = true)
    private MainStageOperation(@NonNull Printer out,
                               @NonNull Reader reader,
                               @NonNull Storage storage) {
        this.out = out;
        this.reader = reader;
        this.storage = storage;
    }

    @Override
    public void proceed() {
        String message = "" +
                "----------------------------------------\n" +
                " 1 - load CSV\n" +
                " 2 - Print out all books and magazines\n" +
                " 3 - Find book or by its isbn\n" +
                " 4 - Find all books and magazines by their authors email\n" +
                " 5 - Print out all books and magazines with their details sorted by title\n" +
                " 0 - exit\n" +
                "----------------------------------------\n" +
                "operation: ";

        int code = -1;
        while (code != 0) {
            out.print(message);
            switch (code = reader.readInt()) {
                case 1: {

                    ChooseCsvTypeOperation.builder()
                            .out(out)
                            .reader(reader)
                            .storage(storage)
                            .build()
                            .proceed();

                    break;
                }
                case 2: {
                    System.out.println("case 2");
                    break;
                }
                case 3: {
                    System.out.println("case 3");
                    break;
                }
                case 4: {
                    System.out.println("case 4");
                    break;
                }
                case 5: {
                    System.out.println("case 5");
                    break;
                }
                default: {
                    out.println("!!! bad input !!!");
                }
            }
        }
    }
}
