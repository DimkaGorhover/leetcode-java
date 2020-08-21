package org.gd.apptopia;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-19
 */
public class App {

    public static void main(String[] args) throws IOException {

        List<String> fileName = Arrays.asList(
                "testcases/file1.txt",
                "testcases/file2.txt",
                "testcases/file3.txt",
                "testcases/file4.txt",
                "testcases/file5.txt"
        );

        List<BufferedReader> readers = fileName.stream()
                .map(s -> {
                    File file = new File("/home/dimka/dev/git/apptopia/src/main/resources/" + s);
                    try {
                        return new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

        File file = new File("/home/dimka/dev/git/apptopia/src/main/resources/merge.txt");

        Writer writer = new FileWriter(file);

        List<Entry> entries = readers.stream()
                .map(reader -> Entry.of(new FileLinesIterator(reader)))
                .collect(Collectors.toList());

        Heap heap = new Heap(entries);
        Entry last = heap.poll();
        Entry entry;
        while ((entry = heap.poll()) != null) {
            if (last.compareTo(entry) == 0) {
                last = last.mergeValues(entry);
            } else {
                writer.append(last.toString()).append('\n');
                last = entry;
            }
        }

        writer.append(last.toString()).append('\n').flush();
        writer.close();

        for (BufferedReader reader : readers) {
            reader.close();
        }

    }
}
