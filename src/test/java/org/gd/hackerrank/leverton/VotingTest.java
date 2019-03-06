package org.gd.hackerrank.leverton;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Voting};
 *
 * @author Horkhover Dmytro
 * @since 2019-03-06
 */
class VotingTest {

    @Test
    @DisplayName("ElectionWinner")
    void test_ElectionWinner() {
        assertEquals(
                "Veronica",
                Voting.electionWinner(new String[]{
                        "Victor",
                        "Veronica",
                        "Ryan",
                        "Dave",
                        "Maria",
                        "Maria",
                        "Farah",
                        "Farah",
                        "Ryan",
                        "Veronica"
                }));
    }
}