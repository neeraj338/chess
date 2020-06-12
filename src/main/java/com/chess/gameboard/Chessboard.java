package com.chess.gameboard;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            }
            return isValidCellPosition(row, col)
                    ? Optional.of(this.chessBoard.get(row).get(col)) : Optional.empty();

        }
        return Optional.empty();
    }

    public Optional<Cell> moveDiagonal(Cell beginCell, int byPosition, Direction direction) {
        return Optional.empty();
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
