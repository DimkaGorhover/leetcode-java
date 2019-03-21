package ai.leverton.kata.library.cli;

import lombok.NonNull;
import lombok.ToString;

import java.io.InputStream;
import java.util.Scanner;

@ToString(doNotUseGetters = true)
class ScannerReader implements Reader {

    private final Scanner scanner;

    private ScannerReader(@NonNull Scanner scanner) { this.scanner = scanner; }

    static ScannerReader of(@NonNull InputStream stream) { return new ScannerReader(new Scanner(stream));}

    @Override
    public int readInt() {
        try {
            return Integer.parseInt(read());
        } catch (NumberFormatException ignore) {
            return -1;
        }
    }

    @Override
    public String read() { return scanner.next().trim(); }
}
