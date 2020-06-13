package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;

import java.util.List;

public class Bishop implements Piece {
    @Override
    public List<Cell> possibleMoves(Chessboard chessboard, String beginCell) {
        List<Cell> cells = chessboard.moveDiagonally(beginCell);
        return cells;
    }
}
