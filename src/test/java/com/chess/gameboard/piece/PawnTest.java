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
        chessboard.initializeGame();
        Piece pawn = new Pawn();
        Optional<Cell> cell = chessboard.findCellById("E4");
        List<Cell> possibleCells = pawn.possibleMoves(cell.get());
        Optional<Cell> targetCell = chessboard.findCellById("E5");
        Assert.assertThat(1, Matchers.is(Matchers.equalTo(possibleCells.size())));
        Assert.assertThat(possibleCells, Matchers.allOf(Matchers.hasItem(targetCell.get())));
    }

    @Test
    @DisplayName("pawns can't move if reach to end ")
    public void testPawnsMoveNotAllowedFromTopRowsCell() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Piece pawn = new Pawn();
        Optional<Cell> cell = chessboard.findCellById("H8");
        List<Cell> possibleCells = pawn.possibleMoves(cell.get());
        Assert.assertThat(true, Matchers.is(Matchers.equalTo(possibleCells.isEmpty())));
    }

}
