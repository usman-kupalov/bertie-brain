import model.Field;
import model.Figure;
import model.Game;
import model.Player;
import view.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String firstNameOfFirstPlayer = playerNameInput(1);
        final String firstNameOfSecondPlayer = playerNameInput(2);

        final Player[] players = new Player[2];
        players[0] = new Player(firstNameOfFirstPlayer, Figure.X);
        players[1] = new Player(firstNameOfSecondPlayer, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

    static String playerNameInput(final int count) {
        Scanner scanner = new Scanner(System.in);
        System.out.format("Enter player %s name: ", count);
        String inputName = scanner.nextLine();
        return inputName;
    }
}