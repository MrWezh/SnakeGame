package SnakeGame;
import java.util.Scanner;

public class Terminal {
	
	private Scanner wz; 
	private Board board; 
	CleanTerminal clean; 
	

	Terminal(){
		wz = new Scanner(System.in);
		board = new Board();
		clean = new CleanTerminal();
	}
	
	
	
	public Board getBoard() {
		return board;
	}


	public int gameMenu(){
		clean.clearScreen();
		System.out.println("╔═════════════════╗");
		System.out.println("║ 1. START GAME   ║");
		System.out.println("║ 2. HOW TO PLAY? ║");
		System.out.println("║ 0. EXIT         ║");
		System.out.println("╚═════════════════╝");
		System.out.println("-------------------");
		System.out.println();
		System.out.print("ENTER YOUR OPTION: ");
		System.out.println();
		
		int option = wz.nextInt(); 
		wz.nextLine();
		
		return option; 
	}
	
	public void askUserInformationtoInitBoard() {
		clean.clearScreen();
		System.out.println("╔═════════════════════════════════════════════════╗");
		System.out.println("║            THE BOARD WILL BE SQUARE             ║");
		System.out.println("║           AND MINIMUM BOARD SIZE IS 4           ║");
		System.out.println("╚═════════════════════════════════════════════════╝");
		System.out.println("---------------------------------------------------");
		System.out.print("Enter what size do you want to put for your board: ");

		int size = wz.nextInt();
		
		if (size < 4) {
				while (true) {
					clean.clearScreen();
				System.out.println("********************ERROR, SIZE INCORRECT*******************");
				System.out.println("****THE SIZE SHOULD BE POSITIVE(MINIMUM BOARD SIZE IS 4)****");
				System.out.println("------------------------------------------------------------"); 
				System.out.print("PLEASE, RE-ENTER THE BOARD SIZE: ");
				size = wz.nextInt();
				
				if (size >= 4 ) { 
					this.board.setSize(size); 
				
					 break;}
				
				}
				
			
		}
		
		else{ 
			this.board.setSize(size); 
			}

		int boarDimension = this.board.getSize()* this.board.getSize()-3;
		System.out.print("POINTS YOU WANT TO GET TO WIN(MAX "+(boarDimension)+" points): ");
		int goal = wz.nextInt();

			if(goal > boarDimension){
				while (true) {
					System.out.println("********************ERROR, GOAL INCORRECT*******************");
					System.out.println("*******************THIS GOAL IS IMPOSSIBLE******************");
					System.out.println("------------------------------------------------------------"); 
					System.out.print("PLEASE, RE-ENTER THE YOUR GOAL: ");
					goal = wz.nextInt();
					
					if (goal <= boarDimension ) { 
						this.board.setGoal(goal); 
					
						 break;}
					
					}
			}
			else this.board.setGoal(goal);

		
	}


	public void askUserToSetMoviment(){

		System.out.println();
		System.out.print("Snake Moviment(a/w/s/d): ");
		String Moviment = wz.next().toLowerCase();
		


		this.board.snakeMovement(Moviment.charAt(0)); 

	}


	public boolean askUserIfTheyWantToContinueTheGame(){
		board.setPoints(0);

		String option = wz.next().toLowerCase();

		switch(option){
			case "y":
				
				return true; 
				
			case "n":

				return false; 

			default: 
			clean.clearScreen();
		
			System.out.println("(y) to play another game.");
			System.out.println("(n) to finish the game.");
			System.out.print("Option INCORECT, please re-write your option:");
			askUserIfTheyWantToContinueTheGame();

			return false;
		}

		
	}

	public void howToPlay(){
		System.out.println("╔════════════════════════════════════════════════════════════════════╗");
		System.out.println("║CONTROLS:                                                           ║");
		System.out.println("║ w -> to go up                                                      ║");
		System.out.println("║ a -> to go left                                                    ║");
		System.out.println("║ s -> to go down                                                    ║");
		System.out.println("║ d -> to go right                                                   ║");
		System.out.println("║────────────────────────────────────────────────────────────────────║");
		System.out.println("║RULES:                                                              ║");
		System.out.println("║ 1.To win you have to reach certain points (goal) by eating apples, ║");
		System.out.println("║ this points will be chosen by the player.                          ║");
		System.out.println("║ 2.The game ends when the player collides with the edge of the board║");
		System.out.println("║ or collides with himself.                                          ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════╝");
		System.out.println();

	}


}
