package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;

import java.util.List;

public class Rook implements Piece {

    @Override
    public List<Cell> possibleMoves(Cell beginCell) {
        Chessboard chessboard = beginCell.getChessboard();
        List<Cell> cells = chessboard.allHorizontalVerticalCells(beginCell.getId());
        return cells;
    }
}
