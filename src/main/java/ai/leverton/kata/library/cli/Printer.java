package ai.leverton.kata.library.cli;

import java.io.PrintStream;

public interface Printer {

    static Printer of(PrintStream stream) { return new PrintStreamPrinter(stream); }

    void print(String s);

    default void println(String s) {
        print(s);
        print("\n");
    }

    default void print(Object s) {
        if (s != null)
            print(String.valueOf(s));
    }
}
