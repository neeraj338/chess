package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;

import java.util.List;

public interface Piece {

    List<Cell> possibleMoves(Chessboard chessboard, String beginCell);
}
