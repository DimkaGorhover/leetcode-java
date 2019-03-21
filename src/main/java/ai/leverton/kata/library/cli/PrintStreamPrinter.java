package ai.leverton.kata.library.cli;

import lombok.NonNull;
import lombok.ToString;

import java.io.PrintStream;

@ToString(doNotUseGetters = true)
class PrintStreamPrinter implements Printer {

    private final PrintStream writer;

    PrintStreamPrinter(@NonNull PrintStream writer) { this.writer = writer; }

    @Override
    public void print(String s) { writer.print(s); }

    @Override
    public void println(String s) { writer.println(s); }

    @Override
    public void print(Object s) { writer.println(s); }
}
