package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import com.chess.gameboard.Direction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class King implements Piece {

    @Override
    public List<Cell> possibleMoves(Chessboard chessboard, String beginCell) {
        List<Cell> cells = Stream.of(Direction.values())
                .map(direction -> chessboard.move(beginCell, 1, direction))
                .filter(cell -> cell.isPresent())
                .map(cell -> cell.get())
                .collect(Collectors.toList());

        return cells;
    }
}
