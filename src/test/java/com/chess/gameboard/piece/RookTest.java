package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RookTest {

    @Test
    @DisplayName("test for bishop move ")
    public void testRookMove() {
        Chessboard chessboard = new Chessboard();
        Piece rook = new Rook();
        List<Cell> possibleCells = rook.possibleMoves(chessboard, "F6");
        Assert.assertThat(possibleCells
                , Matchers.containsInAnyOrder(
                        Matchers.hasProperty("id", Matchers.is("F1"))
                        , Matchers.hasProperty("id", Matchers.is("F2"))
                        , Matchers.hasProperty("id", Matchers.is("F3"))
                        , Matchers.hasProperty("id", Matchers.is("F4"))
                        , Matchers.hasProperty("id", Matchers.is("F5"))
                        , Matchers.hasProperty("id", Matchers.is("F7"))
                        , Matchers.hasProperty("id", Matchers.is("F8"))
                        , Matchers.hasProperty("id", Matchers.is("A6"))
                        , Matchers.hasProperty("id", Matchers.is("B6"))
                        , Matchers.hasProperty("id", Matchers.is("C6"))
                        , Matchers.hasProperty("id", Matchers.is("D6"))
                        , Matchers.hasProperty("id", Matchers.is("E6"))
                        , Matchers.hasProperty("id", Matchers.is("G6"))
                        , Matchers.hasProperty("id", Matchers.is("H6"))

                ));
    }
}
