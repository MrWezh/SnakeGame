package SnakeGame; 

public class Main{


	
	public static void main(String[] args) {
		
		Terminal terminal = new Terminal(); 
		CleanTerminal clear = new CleanTerminal();


		int option = terminal.gameMenu();


		switch (option) {
			case 1:

				boolean gameOver = terminal.getBoard().LoseGame(false);
				terminal.askUserInformationtoInitBoard();
				terminal.getBoard().initBoard();
				
				do {clear.clearScreen();
					terminal.getBoard().print();
					terminal.askUserToSetMoviment();
					clear.clearScreen();
				
				} while(gameOver);
				//break;
				
			case 2:
				// Código para el caso 2
				break;
				
			default:
				// Código para el caso por defecto
				break;
		}
		
	}
}

		
