package com.chess.gameboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cell {
    private int row;
    private int col;

    @EqualsAndHashCode.Include
    private String id;

    private Chessboard chessboard;

    public Cell(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s(%d, %d)", id, row, col);
    }
}