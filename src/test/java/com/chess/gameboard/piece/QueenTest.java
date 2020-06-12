package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class QueenTest {

    @Test
    @DisplayName("test for queen move ")
    public void testQueenMove() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Piece queen = new Queen();
        Optional<Cell> cell = chessboard.findCellById("A8");
        List<Cell> possibleCells = queen.possibleMoves(cell.get());
        Assert.assertThat(possibleCells
                , Matchers.containsInAnyOrder(
                        Matchers.hasProperty("id", Matchers.is("A1"))
                        , Matchers.hasProperty("id", Matchers.is("A2"))
                        , Matchers.hasProperty("id", Matchers.is("A3"))
                        , Matchers.hasProperty("id", Matchers.is("A4"))
                        , Matchers.hasProperty("id", Matchers.is("A5"))
                        , Matchers.hasProperty("id", Matchers.is("A6"))
                        , Matchers.hasProperty("id", Matchers.is("A7"))
                        , Matchers.hasProperty("id", Matchers.is("B8"))
                        , Matchers.hasProperty("id", Matchers.is("C8"))
                        , Matchers.hasProperty("id", Matchers.is("D8"))
                        , Matchers.hasProperty("id", Matchers.is("E8"))
                        , Matchers.hasProperty("id", Matchers.is("F8"))
                        , Matchers.hasProperty("id", Matchers.is("G8"))
                        , Matchers.hasProperty("id", Matchers.is("H8"))
                        , Matchers.hasProperty("id", Matchers.is("B7"))
                        , Matchers.hasProperty("id", Matchers.is("C6"))
                        , Matchers.hasProperty("id", Matchers.is("D5"))
                        , Matchers.hasProperty("id", Matchers.is("E4"))
                        , Matchers.hasProperty("id", Matchers.is("F3"))
                        , Matchers.hasProperty("id", Matchers.is("G2"))
                        , Matchers.hasProperty("id", Matchers.is("H1"))

                ));
    }
}
