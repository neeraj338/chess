package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import com.chess.gameboard.Direction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Pawn implements Piece {
    @Override
    public List<Cell> possibleMoves(Chessboard chessboard, String beginCell) {
        Optional<Cell> cell = chessboard.move(beginCell, 1, Direction.UP);
        return cell.isPresent() ? Arrays.asList(cell.get()) : Collections.emptyList();
    }
}
