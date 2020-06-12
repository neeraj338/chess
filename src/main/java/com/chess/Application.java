package com.chess;

import com.chess.gameboard.Cell;
import com.chess.gameboard.Chessboard;
import com.chess.gameboard.piece.*;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Log
public class Application {
    private static final List<Class<? extends Piece>>
            piecesClass = Arrays.asList(Bishop.class
            , Horse.class
            , King.class
            , Queen.class
            , Rook.class
            , Pawn.class);

    public static void main(String[] arg) throws IllegalAccessException, InstantiationException {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeGame();
        log.info(chessboard.toString());
        log.info("Enter a command or press any key to terminate ");
        try (Scanner sc = new Scanner(System.in);) {
            while (true) {

                String command = sc.nextLine();
                if (command.length() == 0 || command.length() == 1) {
                    System.exit(0);
                } else {
                    String[] pieceAndCell = command.split(" ");
                    Optional<Class<? extends Piece>> optionalClass = piecesClass
                            .stream()
                            .filter(cls -> cls.getSimpleName().equalsIgnoreCase(pieceAndCell[0]))
                            .findAny();
                    Optional<Cell> cell = chessboard.findCellById(pieceAndCell[1]);
                    if (optionalClass.isPresent()
                            && cell.isPresent()) {
                        Piece piece = optionalClass.get().newInstance();
                        List<Cell> cells = piece.possibleMoves(cell.get());
                        log.info(cells.toString());
                    } else {
                        log.info("wrong input please try again");
                    }
                }

                log.info("Enter a command or press any key to terminate ");
            }
        }

    }

}
