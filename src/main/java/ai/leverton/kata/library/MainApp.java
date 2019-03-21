package ai.leverton.kata.library;

import ai.leverton.kata.library.cli.MainStageOperation;
import ai.leverton.kata.library.cli.Printer;
import ai.leverton.kata.library.cli.Reader;
import ai.leverton.kata.library.storage.InMemoryCustomStorage;

public class MainApp {

    public static void main(String[] args) {

        MainStageOperation.builder()
                .out(Printer.of(System.out))
                .reader(Reader.of(System.in))
                .storage(new InMemoryCustomStorage())
                .build()
                .proceed();

        System.out.println("see u next time :)");
    }
}
