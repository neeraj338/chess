package com.chess.gameboard.piece;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import com.chess.gameboard.Direction;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Horse implements Piece {

    private static List<Cell> moveOnePositionLeftOrRight(Cell sourceCell, Chessboard chessboard) {
        return Stream.of(Direction.LEFT
                , Direction.RIGHT)
                .map(direction -> chessboard.move(sourceCell.getId(), 1, direction))
                .filter(cell -> cell.isPresent())
                .map(cell -> cell.get())
                .collect(Collectors.toList());
    }

    private static List<Cell> moveOnePositionUpOrDown(Cell sourceCell, Chessboard chessboard) {
        return Stream.of(Direction.UP
                , Direction.DOWN)
                .map(direction -> chessboard.move(sourceCell.getId(), 1, direction))
                .filter(cell -> cell.isPresent())
                .map(cell -> cell.get())
                .collect(Collectors.toList());
    }

    @Override
    public List<Cell> possibleMoves(Chessboard chessboard, String beginCell) {
        Optional<Cell> twoPositionLeft = chessboard.move(beginCell
                , 2, Direction.LEFT);

        Optional<Cell> twoPositionRight = chessboard.move(beginCell
                , 2, Direction.RIGHT);

        Optional<Cell> twoPositionUp = chessboard.move(beginCell
                , 2, Direction.UP);

        Optional<Cell> twoPositionDown = chessboard.move(beginCell
                , 2, Direction.DOWN);

        List<Cell> horseLocations = Stream.of(
                twoPositionUp
                , twoPositionDown)
                .filter(cell -> cell.isPresent())
                .map(cell -> cell.get())
                .flatMap(cell -> Horse.moveOnePositionLeftOrRight(cell, chessboard).stream())
                .collect(Collectors.toList());

        Stream.of(
                twoPositionLeft
                , twoPositionRight)
                .filter(cell -> cell.isPresent())
                .map(cell -> cell.get())
                .flatMap(cell -> Horse.moveOnePositionUpOrDown(cell, chessboard).stream())
                .collect(Collectors.toCollection(() -> horseLocations));

        return horseLocations;

    }
}
