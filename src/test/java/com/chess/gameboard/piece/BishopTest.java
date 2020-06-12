package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class BishopTest {

    @Test
    @DisplayName("test for bishop move ")
    public void testBishopMove() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Piece bishop = new Bishop();
        Optional<Cell> cell = chessboard.findCellById("G2");
        List<Cell> possibleCells = bishop.possibleMoves(cell.get());
        Assert.assertThat(possibleCells
                , Matchers.containsInAnyOrder(
                        Matchers.hasProperty("id", Matchers.is("H1"))
                        , Matchers.hasProperty("id", Matchers.is("H3"))
                        , Matchers.hasProperty("id", Matchers.is("F1"))
                        , Matchers.hasProperty("id", Matchers.is("F3"))
                        , Matchers.hasProperty("id", Matchers.is("E4"))
                        , Matchers.hasProperty("id", Matchers.is("D5"))
                        , Matchers.hasProperty("id", Matchers.is("C6"))
                        , Matchers.hasProperty("id", Matchers.is("B7"))
                        , Matchers.hasProperty("id", Matchers.is("A8"))

                ));
    }
}
