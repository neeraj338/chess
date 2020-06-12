package com.chess.gameboard;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChessboardTest {

    @Test
    @DisplayName("initialize game ")
    public void testInitChessGame() {
        List<List<Cell>> chessBoard = new ArrayList<>();
        List<Cell> cells = new ArrayList<>();
        Chessboard chessboard = new Chessboard(chessBoard, cells);
        chessboard.initializeGame();
        Assert.assertThat(false, Matchers.equalTo(chessBoard.isEmpty()));
        Assert.assertThat(false, Matchers.equalTo(cells.isEmpty()));
        Assert.assertThat(64, Matchers.equalTo(cells.size()));
    }

    @Test
    @DisplayName("should find the given cell by cell id e.g. H2")
    public void testFindCellById() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> cell = chessboard.findCellById("H2");
        Assert.assertThat(true, Matchers.equalTo(cell.isPresent()));
        Assert.assertThat(1, Matchers.equalTo(cell.get().getRow()));
        Assert.assertThat(7, Matchers.equalTo(cell.get().getCol()));
    }

    @Test
    @DisplayName("should not empty for wrong cell id e.g. I1")
    public void testFindCellByIdFailForCellKeyI1() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> cell = chessboard.findCellById("I1");
        Assert.assertThat(false, Matchers.equalTo(cell.isPresent()));
    }

    @Test
    @DisplayName("Should move one position towards left")
    public void testMoveToLeftOnePosition() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> destinationCell = chessboard.move("H2", 1, Direction.LEFT);
        Optional<Cell> targetCell = chessboard.findCellById("G2");
        Assert.assertThat(true, Matchers.equalTo(destinationCell.isPresent()));
        Assert.assertThat(targetCell.get(), Matchers.equalTo(destinationCell.get()));
    }

    @Test
    @DisplayName("Should move one position towards right")
    public void testMoveToRightOnePosition() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> destinationCell = chessboard.move("E4", 1, Direction.RIGHT);
        Optional<Cell> targetCell = chessboard.findCellById("F4");
        Assert.assertThat(true, Matchers.equalTo(destinationCell.isPresent()));
        Assert.assertThat(targetCell.get(), Matchers.equalTo(destinationCell.get()));
    }

    @Test
    @DisplayName("Should move one position towards Up")
    public void testMoveToUpOnePosition() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> destinationCell = chessboard.move("E4", 1, Direction.UP);
        Optional<Cell> targetCell = chessboard.findCellById("E5");
        Assert.assertThat(true, Matchers.equalTo(destinationCell.isPresent()));
        Assert.assertThat(targetCell.get(), Matchers.equalTo(destinationCell.get()));
    }

    @Test
    @DisplayName("Should move one position towards Down")
    public void testMoveToDownOnePosition() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> destinationCell = chessboard.move("E4", 1, Direction.DOWN);
        Optional<Cell> targetCell = chessboard.findCellById("E3");
        Assert.assertThat(true, Matchers.equalTo(destinationCell.isPresent()));
        Assert.assertThat(targetCell.get(), Matchers.equalTo(destinationCell.get()));
    }

    @Test
    @DisplayName("Should return empty one position Left from any cell from first column")
    public void testMoveToLeftOnePositionFromFirstColumn() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> destinationCell = chessboard.move("A5", 1, Direction.LEFT);
        Assert.assertThat(false, Matchers.equalTo(destinationCell.isPresent()));
    }

    @Test
    @DisplayName("Should return empty one position RIGHT from any cell from last column")
    public void testMoveToRightOnePositionFromLstColumn() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> destinationCell = chessboard.move("H8", 1, Direction.RIGHT);
        Assert.assertThat(false, Matchers.equalTo(destinationCell.isPresent()));
    }

    @Test
    @DisplayName("Should return empty one position UP from any cell from first row")
    public void testMoveToUpOnePositionFromFirstRow() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> destinationCell = chessboard.move("A8", 1, Direction.UP);
        Assert.assertThat(false, Matchers.equalTo(destinationCell.isPresent()));
    }

    @Test
    @DisplayName("Should return empty one position Down from any cell from last row")
    public void testMoveToDownOnePositionFromLstRow() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        Optional<Cell> destinationCell = chessboard.move("B1", 1, Direction.DOWN);
        Assert.assertThat(false, Matchers.equalTo(destinationCell.isPresent()));
    }
}
