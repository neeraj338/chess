package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;

import java.util.List;

public class Queen implements Piece {
    @Override
    public List<Cell> possibleMoves(Chessboard chessboard, String beginCell) {
        List<Cell> horizontalCells = chessboard.moveHorizontallyVertically(beginCell);
        List<Cell> verticalCells = chessboard.moveDiagonally(beginCell);

        horizontalCells.addAll(verticalCells);
        return horizontalCells;
    }
}
