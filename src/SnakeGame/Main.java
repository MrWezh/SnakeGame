package SnakeGame;
import java.util.Scanner;

public class Main {

    public static Scanner wz = new Scanner(System.in);
    public static Terminal terminal;
    public static CleanTerminal clear;

    public static void initGame() {
        int option = terminal.gameMenu();

        switch (option) {
            case 1:
                clear.clearScreen();
                startGame();
                break;
            case 2:
                clear.clearScreen();
                howToPlay();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public static void startGame() {
        boolean gameOver = false;
        terminal.askUserInformationtoInitBoard();
        clear.clearScreen();
        terminal.getBoard().initBoard();

        do {

            clear.clearScreen();
            terminal.getBoard().print();
            terminal.askUserToSetMoviment();
            clear.clearScreen();
            gameOver = terminal.getBoard().gameWin();

        } while (!gameOver);
        System.out.println("You win!!!");

        System.out.println("Do you want to continue the game?(y/n):");
        if (terminal.askUserIfTheyWantToContinueTheGame()) {

            startGame();

        } else {
            System.exit(0);
        }
    }

    public static void howToPlay() {

		terminal.howToPlay();
        System.out.println("0.Go back");

        int suboption = wz.nextInt();

        System.out.println();

        if (suboption == 0) { initGame();} 
		
		else {
            System.out.println("Option INCORECT, please re-write the option:");
            howToPlay();
        }
    }

    public static void main(String[] args) {
        terminal = new Terminal();
        clear = new CleanTerminal();
        initGame();
    }
}
