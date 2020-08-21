package org.gd.apptopia;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-20
 */
public class FileLinesIterator implements Iterator<String> {

    private final BufferedReader reader;
    private String line = null;

    public FileLinesIterator(BufferedReader reader) {
        this.reader = reader;
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException ignored) {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return line != null || (line = readLine()) != null;
    }

    @Override
    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        String line = this.line;
        this.line = null;
        return line;
    }
}
