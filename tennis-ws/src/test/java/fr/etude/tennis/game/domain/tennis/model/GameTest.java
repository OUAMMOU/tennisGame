package fr.etude.tennis.game.domain.tennis.model;

import fr.etude.tennis.game.domain.tennis.model.state.AdvantageState;
import fr.etude.tennis.game.domain.tennis.model.state.DeuceState;
import fr.etude.tennis.game.domain.tennis.model.state.NormalState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testInitialState() {
        assertInstanceOf(NormalState.class, game.getCurrentState());
        assertEquals(0, game.getPlayerAScore());
        assertEquals(0, game.getPlayerBScore());
    }

    @Test
    void testIncrementScore() {
        Player playerA = game.getPlayerA();
        game.incrementScore(playerA);
        assertEquals(15, game.getPlayerAScore());
        assertEquals(0, game.getPlayerBScore());
    }

    @Test
    void testWinPoint_and_passe_to_dueuce_state() {
        //Given
        Player playerA = game.getPlayerA();
        Player playerB = game.getPlayerB();

        //When
        game.winPoint(playerA);
        game.winPoint(playerA);
        game.winPoint(playerA);
        game.winPoint(playerB);
        game.winPoint(playerB);
        game.winPoint(playerB);

        //Then
        assertInstanceOf(DeuceState.class, game.getCurrentState());
    }

@Test
    void testWinPoint_and_passe_to_advantage_state() {
        Player playerA = game.getPlayerA();
        game.setState(new DeuceState());
        game.winPoint(playerA);

        assertInstanceOf(AdvantageState.class, game.getCurrentState());
    }


    @Test
    void testSetWinner() {
        Player playerA = game.getPlayerA();
        game.setWinner(playerA);
        assertEquals(playerA, game.getWinner());
    }
}