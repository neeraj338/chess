package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;

import java.util.ArrayList;
import java.util.List;

public class Queen implements Piece {
    @Override
    public List<Cell> possibleMoves(Cell beginCell) {
        Chessboard chessboard = beginCell.getChessboard();
        List<Cell> horizontalCells = chessboard.allHorizontalVerticalCells(beginCell.getId());
        List<Cell> verticalCells = chessboard.allDiagonalCells(beginCell.getId());

        horizontalCells.addAll(verticalCells);
        return horizontalCells;
    }
}
