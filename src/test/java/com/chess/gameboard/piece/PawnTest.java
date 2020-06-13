package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class PawnTest {

    @Test
    @DisplayName("pawns move to up except top cells")
    public void testPawnsMove() {
        Chessboard chessboard = new Chessboard();
        Piece pawn = new Pawn();
        List<Cell> possibleCells = pawn.possibleMoves(chessboard, "E4");
        Optional<Cell> targetCell = chessboard.findCellById("E5");
        Assert.assertThat(1, Matchers.is(Matchers.equalTo(possibleCells.size())));
        Assert.assertThat(possibleCells, Matchers.allOf(Matchers.hasItem(targetCell.get())));
    }

    @Test
    @DisplayName("pawns can't move if reach to end ")
    public void testPawnsMoveNotAllowedFromTopRowsCell() {
        Chessboard chessboard = new Chessboard();
        Piece pawn = new Pawn();
        List<Cell> possibleCells = pawn.possibleMoves(chessboard, "H8");
        Assert.assertThat(true, Matchers.is(Matchers.equalTo(possibleCells.isEmpty())));
    }

}
