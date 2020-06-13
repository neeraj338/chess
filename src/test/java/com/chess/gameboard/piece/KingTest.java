package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KingTest {

    @Test
    @DisplayName("test for king move ")
    public void testKingMove() {
        Chessboard chessboard = new Chessboard();
        Piece king = new King();
        List<Cell> possibleCells = king.possibleMoves(chessboard, "A4");
        Assert.assertThat(possibleCells
                , Matchers.containsInAnyOrder(
                        Matchers.hasProperty("id", Matchers.is("B3"))
                        , Matchers.hasProperty("id", Matchers.is("B4"))
                        , Matchers.hasProperty("id", Matchers.is("B5"))
                        , Matchers.hasProperty("id", Matchers.is("A5"))
                        , Matchers.hasProperty("id", Matchers.is("A3"))));
    }

    @Test
    @DisplayName("test for king move ")
    public void testKingMoveChooseCellInCenter() {
        Chessboard chessboard = new Chessboard();
        Piece king = new King();
        List<Cell> possibleCells = king.possibleMoves(chessboard, "E4");
        Assert.assertThat(possibleCells
                , Matchers.containsInAnyOrder(
                        Matchers.hasProperty("id", Matchers.is("D3"))
                        , Matchers.hasProperty("id", Matchers.is("D4"))
                        , Matchers.hasProperty("id", Matchers.is("D5"))
                        , Matchers.hasProperty("id", Matchers.is("E3"))
                        , Matchers.hasProperty("id", Matchers.is("E5"))
                        , Matchers.hasProperty("id", Matchers.is("F3"))
                        , Matchers.hasProperty("id", Matchers.is("F4"))
                        , Matchers.hasProperty("id", Matchers.is("F5"))

                ));
    }
}
