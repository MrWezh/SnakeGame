package SnakeGame;

public class Main {

	public static void main(String[] args) {
		
		Terminal terminal = new Terminal(); 
		
		int option = terminal.gameMenu();
		
		
		switch (option) {
			
		case 1: 
			boolean finishGame=false;
			terminal.askUserInformationtoInitBoard();
			terminal.getBoard().initBoard();
			terminal.getBoard().print();
			while (finishGame) {
				
				terminal.getBoard().snakeMovement();
				finishGame = terminal.getBoard().LoseGame();
				finishGame  = terminal.getBoard().winGame();
			}
			
			break; 
		case 2: //crear un fichero donde exl¡plica las normas del juego.
			break; 
		case 0:
			System.exit(0);
			break; 
			
		}
		
		

	}

}
