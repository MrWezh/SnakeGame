package SnakeGame; 

public class Main{


	
	public static void main(String[] args) {
		
		Terminal terminal = new Terminal(); 
		CleanTerminal clear = new CleanTerminal();


		int option = terminal.gameMenu();


		switch (option) {
			
			case 2:
				// Código para el caso 2
				break;

			case 0: 
				System.exit(0);
				break;

				case 1:

				boolean gameOver = false;
				terminal.askUserInformationtoInitBoard();
				terminal.getBoard().initBoard();
				
				do {clear.clearScreen();
					terminal.getBoard().print();
					terminal.askUserToSetMoviment();
					clear.clearScreen();
					gameOver = terminal.getBoard().gameOver();
				} while(!gameOver);
				System.out.println("You win!!!");
				break;

			default:
				// Código para el caso por defecto
				break;
		}
		
	}
}

		
