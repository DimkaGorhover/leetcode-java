package ai.leverton.kata.library.cli;

import ai.leverton.kata.library.domain.DomainObjectType;
import ai.leverton.kata.library.storage.Storage;
import lombok.NonNull;

class ChooseCsvTypeOperation implements Operation {

    private final Printer out;
    private final Reader  reader;
    private final Storage storage;

    @lombok.Builder(builderClassName = "Builder", toBuilder = true)
    private ChooseCsvTypeOperation(@NonNull Printer out,
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
                " 1 - Load Authors\n" +
                " 2 - Load Books\n" +
                " 3 - Load Magazines\n" +
                " 0 - back\n" +
                "----------------------------------------\n" +
                "operation: ";

        int code = -1;
        while (code != 0) {
            out.print(message);
            switch (code = reader.readInt()) {
                case 1: {

                    EnterLoadPathOperation.builder()
                            .out(out)
                            .reader(reader)
                            .domainObjectType(DomainObjectType.AUTHOR)
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
                default: {
                    out.println("!!! bad input !!!");
                }
            }
        }
    }

}
