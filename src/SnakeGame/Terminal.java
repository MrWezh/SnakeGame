package SnakeGame;
import java.util.*;

public class Terminal {
	
	private Scanner wz; 
	private Board board; 
	

	Terminal(){
		wz = new Scanner(System.in);
		board = new Board();
	}
	
	
	
	public Board getBoard() {
		return board;
	}


	public int gameMenu(){
		System.out.println("1. START GAME");
		System.out.println("2. HOW TO PLAY?");
		System.out.println("0. EXIT");
		System.out.println();
		System.out.print("ENTER YOUR OPTION:");
		System.out.println();
		
		int option = wz.nextInt(); 
		wz.nextLine();
		
		return option; 
	}
	
	public void askUserInformationtoInitBoard() {
		System.out.println("THE BOARD COLUMN WILL BE TWICE AS LARGE AS THE SIZE/ROW");
		System.out.println("ENTER BOARD SIZE(MINIMUM BOARD SIZE IS 4):");
		int size = wz.nextInt();
		
		if (size < 4) {
				while (true) {
				System.out.println("********************ERROR, SIZE INCORRECT*******************");
				System.out.println("****THE SIZE SHOULD BE POSITIVE(MINIMUM BOARD SIZE IS 4)****");
				System.out.println(); 
				System.out.println("PLEASE, RE-ENTER THE BOARD SIZE:");
				size = wz.nextInt();
				
				if (size >= 4 ) { 
					this.board.setSize(size); 
				
					 break;}
				
				}
				
			
		}
		
		else{ 
			this.board.setSize(size); 
			}

		int boarDimension = this.board.getSize()*2;
		System.out.print("POINTS YOU WANT TO GET TO WIN(MAX "+(boarDimension)+" points): ");
		int goal = wz.nextInt();

			if(goal > boarDimension){
				while (true) {
					System.out.println("********************ERROR, GOAL INCORRECT*******************");
					System.out.println("*******************THIS GOAL IS IMPOSSIBLE******************");
					System.out.println(); 
					System.out.println("PLEASE, RE-ENTER THE YOUR GOAL:");
					size = wz.nextInt();
					
					if (goal <= boarDimension ) { 
						this.board.setGoal(goal); 
					
						 break;}
					
					}
			}
			else this.board.setGoal(goal);

		
	}


	public void askUserToSetMoviment(){

		System.out.println();
		System.out.print("Snake Moviment(a/w/s/d):");
		String Moviment = wz.next().toLowerCase();
		


		this.board.snakeMovement(Moviment.charAt(0)); 

	}


}
