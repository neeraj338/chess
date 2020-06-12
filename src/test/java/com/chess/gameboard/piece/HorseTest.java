package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class HorseTest {

    @Test
    @DisplayName("test for horse move ")
    public void testHorseMove() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Piece horse = new Horse();
        Optional<Cell> cell = chessboard.findCellById("E3");
        List<Cell> possibleCells = horse.possibleMoves(cell.get());
        Assert.assertThat(possibleCells
                , Matchers.containsInAnyOrder(
                        Matchers.hasProperty("id", Matchers.is("F5"))
                        , Matchers.hasProperty("id", Matchers.is("G4"))
                        , Matchers.hasProperty("id", Matchers.is("G2"))
                        , Matchers.hasProperty("id", Matchers.is("F1"))
                        , Matchers.hasProperty("id", Matchers.is("D1"))
                        , Matchers.hasProperty("id", Matchers.is("C2"))
                        , Matchers.hasProperty("id", Matchers.is("C4"))
                        , Matchers.hasProperty("id", Matchers.is("D5"))

                ));
    }
}
