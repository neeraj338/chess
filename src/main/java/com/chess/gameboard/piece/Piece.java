package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;

import java.util.List;

public interface Piece {

    List<Cell> possibleMoves(Cell beginCell);
}
