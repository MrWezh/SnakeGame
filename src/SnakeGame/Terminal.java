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
			
			if (size >= 4 ) {int column = size*2; 
				this.board.setSize(size); this.board.setColumn(column); break;}
			
			}
			
			
		}else{ 
			int column = size*2; 
			this.board.setSize(size); this.board.setColumn(column);}
		
	}
	
	

}
