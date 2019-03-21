package ai.leverton.kata.library.cli;

import java.io.InputStream;

public interface Reader {

    static Reader of(InputStream stream) { return ScannerReader.of(stream); }

    /**
     *
     * @return {@code -1} if bad input
     */
    int readInt();

    String read();
}
