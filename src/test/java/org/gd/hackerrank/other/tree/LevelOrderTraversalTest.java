package org.gd.hackerrank.other.tree;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link LevelOrderTraversal}
 *
 * @author Horkhover D.
 * @since 2020-07-15.07.2020
 */
class LevelOrderTraversalTest {

    @Test
    @DisplayName("LevelOrder")
    void test_LevelOrder() throws IOException {

        final PrintStream out = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        Node root = new Node(1,
                null,
                new Node(2,
                        null,
                        new Node(5,
                                new Node(3,
                                        null,
                                        new Node(4)),
                                new Node(6))));

        LevelOrderTraversal.levelOrder(root);

        printStream.flush();
        outputStream.flush();

        System.setOut(out);

        String actual = outputStream.toString(StandardCharsets.ISO_8859_1).trim();

        assertEquals("1 2 5 3 6 4", actual);
    }
}