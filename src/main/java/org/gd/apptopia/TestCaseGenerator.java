package org.gd.apptopia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-20
 */
public class TestCaseGenerator {

    public static void main(String[] args) {



        File file = new File("/home/dimka/dev/git/apptopia/src/main/resources/file5.txt");
        try (Writer writer = new FileWriter(file)) {
            for (int year = 1970; year < 2021; year++) {
                for (int month = 0; month < 12; month++) {
                    for (int day = 1; day < 29; day++) {
                        int valueCount = ThreadLocalRandom.current().nextInt(0, 5);
                        double[] doubles = ThreadLocalRandom.current().doubles(valueCount, -1, 1).toArray();
                        for (double value : doubles) {
                            Record record = new Record(year, month, day, BigDecimal.valueOf(value), 1);
                            writer.append(record.toString());
                            writer.append('\n');
                        }
                    }
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
