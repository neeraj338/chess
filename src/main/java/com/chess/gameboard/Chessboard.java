package com.chess.gameboard;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Chessboard {

    private static final int NUMBER_OF_ROWS = 8;
    private static final int NUMBER_OF_COLS = 8;
    private static final int TOTAL_NO_OF_SQUARE = NUMBER_OF_ROWS * NUMBER_OF_COLS;
    private final List<List<Cell>> chessBoard;
    private final List<Cell> cells;

    public Chessboard() {
        cells = new ArrayList<>(TOTAL_NO_OF_SQUARE);
        chessBoard = new ArrayList<>(NUMBER_OF_COLS);
    }

    public void initializeGame() {
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            List<Cell> rows = new ArrayList<>(NUMBER_OF_COLS);
            char cellNamePrefix = 'A';
            for (int col = 0; col < NUMBER_OF_COLS; col++) {
                Cell cell = new Cell(row, col, String.format("%c%d", cellNamePrefix + col, row + 1), this);
                rows.add(cell);
                this.cells.add(cell);
            }
            this.chessBoard.add(rows);
        }
    }

    public Optional<Cell> move(String cellKey, int byPosition, Direction direction) {
        Optional<Cell> beginCell = this.findCellById(cellKey);
        if (beginCell.isPresent()) {
            Cell sourceCell = beginCell.get();
            int row = sourceCell.getRow();
            int col = sourceCell.getCol();
            if (Direction.LEFT == direction) {
                col = col - byPosition;
            } else if (Direction.RIGHT == direction) {
                col = col + byPosition;
            } else if (Direction.UP == direction) {
                row = row + byPosition;
            } else if (Direction.DOWN == direction) {
                row = row - byPosition;
            } else if (Direction.DIAGONAL_LEFT_UP == direction) {
                row = row + byPosition;
                col = col - byPosition;
            } else if (Direction.DIAGONAL_LEFT_DOWN == direction) {
                row = row - byPosition;
                col = col + byPosition;
            } else if (Direction.DIAGONAL_RIGHT_UP == direction) {
                row = row + byPosition;
                col = col + byPosition;
            } else if (Direction.DIAGONAL_RIGHT_DOWN == direction) {
                row = row - byPosition;
                col = col - byPosition;
            }
            return isValidCellPosition(row, col)
                    ? Optional.of(this.chessBoard.get(row).get(col)) : Optional.empty();

        }
        return Optional.empty();
    }


    public List<Cell> allHorizontalVerticalCells(String cellKey) {
        List<Cell> leftRightCells = this.allCellForCellKey(cellKey
                , Direction.LEFT
                , Direction.RIGHT);

        List<Cell> upDownCells = this.allCellForCellKey(cellKey
                , Direction.UP
                , Direction.DOWN);
        leftRightCells.addAll(upDownCells);
        return leftRightCells;
    }

    public List<Cell> allDiagonalCells(String cellKey) {
        List<Cell> leftDiagonal = this.allCellForCellKey(cellKey
                , Direction.DIAGONAL_LEFT_UP
                , Direction.DIAGONAL_LEFT_DOWN);

        List<Cell> rightDiagonalCells = this.allCellForCellKey(cellKey
                , Direction.DIAGONAL_RIGHT_UP
                , Direction.DIAGONAL_RIGHT_DOWN);
        leftDiagonal.addAll(rightDiagonalCells);
        return leftDiagonal;
    }

    public Optional<Cell> findCellById(String id) {
        Cell cell = new Cell(id);
        int cellIndex = this.cells.indexOf(cell);
        if (cellIndex >= 0) {
            return Optional.of(this.cells.get(cellIndex));
        }
        return Optional.empty();
    }

    private boolean isValidCellPosition(int row, int col) {
        if (row >= 0 && col >= 0 && row < NUMBER_OF_ROWS && col < NUMBER_OF_COLS) {
            return true;
        }
        return false;
    }

    private List<Cell> allCellForCellKey(String cellKey
            , Direction direction
            , Direction counterDirection) {

        List<Optional<Cell>> horizontalCells = new ArrayList<>();
        Optional<Cell> leftCell = this.move(cellKey, 1, direction);
        Optional<Cell> rightCell = this.move(cellKey, 1, counterDirection);
        horizontalCells.add(leftCell);
        horizontalCells.add(rightCell);
        while (leftCell.isPresent() || rightCell.isPresent()) {
            if (leftCell.isPresent()) {
                leftCell = this.move(leftCell.get().getId(), 1, direction);
                horizontalCells.add(leftCell);
            }
            if (rightCell.isPresent()) {
                rightCell = this.move(rightCell.get().getId(), 1, counterDirection);
                horizontalCells.add(rightCell);
            }
        }
        return horizontalCells.stream()
                .filter(cell -> cell.isPresent())
                .map(cell -> cell.get())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = NUMBER_OF_ROWS - 1; row >= 0; row--) {
            stringBuilder.append("\n");
            stringBuilder.append(chessBoard.get(row));
        }
        return stringBuilder.toString();
    }
}
