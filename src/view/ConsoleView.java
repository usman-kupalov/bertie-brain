package view;

import controller.CurrentMove;
import controller.Move;
import controller.Winner;
import exception.AlreadyOccupiedException;
import exception.InvalidPointException;
import model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private final CurrentMove currentMoveController = new CurrentMove();
    private final Winner winnerController = new Winner();
    private Move moveController = new Move();

    public void show(final Game game) {
        System.out.format("Game game: %s\n", game.getName());
        System.out.println("Players: ");

        for (Player player : game) {
            System.out.format("Players name : %s\n",player.getFirstName(), player.getFirstName());
        }

        final Field field = game.getField();
        for (int i = 0; i < field.getFieldSize(); i++) {
            if (i != 0)
                printSeperator();
            printLine(field, i);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }

        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no moves is left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch(InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %Ss\n", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("0_0 olololoo!!!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field, final int x) {
        for (int i = 0; i < field.getFieldSize(); i++) {
            if (i != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(i, x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeperator() {
        System.out.println("~~~~~~~~~~~");
    }
}
