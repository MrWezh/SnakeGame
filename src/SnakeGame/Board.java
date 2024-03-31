package SnakeGame;
import java.util.*;

public class Board {
	private int size; 
	private Square[][] square;
	private boolean[][] apple;
	private int[][] snakeBody; 

	private int coordenatexHead;
	private int coordenateyHead;

	private int coordenatexTail;
	private int coordenateyTail;

	private int points=0; 
	private int goal; 

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	private void randomGenerateApple() {
		
		Random random = new Random();

        for (int i = 0; i < 1; i++) {
        int CoordenadaXRadoms = random.nextInt(this.size);
        int CoordenadaYRadoms = random.nextInt(this.size);

        if (this.square[CoordenadaXRadoms][CoordenadaYRadoms]==Square.BOARD){
		this.apple[CoordenadaXRadoms][CoordenadaYRadoms] = true; 
        this.square[CoordenadaXRadoms][CoordenadaYRadoms] = Square.APPLE; 
        this.snakeBody[CoordenadaXRadoms][CoordenadaYRadoms] = -1; }
		else i--;
        }
		
	}
	
	public void initBoard() {
		square = new Square[this.size][this.size];
		apple = new boolean[this.size][this.size];
		snakeBody = new int[this.size][this.size];

		this.init();
		this.randomGenerateApple();

		
	}
	
	public void init(){

			//Iniciarizar Tablero

			for (int i = 0; i < square.length; i++) {
				for (int j = 0; j < square[0].length; j++) {
					this.square[i][j] = Square.BOARD; 
					this.snakeBody[i][j] = 0;
				}
			}

			// Colocar la serpiente en la columna central del tablero
			int row = this.size / 2;
			int column = 0;

			this.square[row][column] = Square.SNAKE; 
			this.snakeBody[row][column] = 3; 
			this.coordenatexTail = row; this.coordenateyTail = column; 
			this.square[row][column+1] = Square.SNAKE;
			this.snakeBody[row][column+1] = 2; 
			this.square[row][column+2] = Square.SNAKEHEAD;
			this.snakeBody[row][column+2] = 1; 
			this.coordenatexHead = row; this.coordenateyHead = column+2; 

		}

	private void calculationForSnakeMoviment(){
		for (int i = 0; i < snakeBody.length; i++) {
			for (int j = 0; j < snakeBody[0].length; j++) {
				if (this.square[i][j]!=Square.BOARD){
					if(this.snakeBody[i][j]!=-1){this.snakeBody[i][j]++; 
					this.square[i][j] = Square.SNAKE; }
					if(this.snakeBody[i][j]>(3+points)){this.snakeBody[i][j] = 0;this.square[i][j] = Square.BOARD;}
					}
				}
			}
		}

	private void eatApple(){
		this.square[coordenatexHead][coordenateyHead] =Square.SNAKEHEAD;
		this.apple[coordenatexHead][coordenateyHead]=false;
		this.snakeBody[coordenatexHead][coordenateyHead]=1;
		this.points++;
		this.randomGenerateApple();
	}
	
	
	public void snakeMovement(char input) {
		
		switch (input) {
			case 'a':
			

				if(coordenateyHead-1==-1||this.snakeBody[coordenatexHead][coordenateyHead-1]>3){
					System.out.println("GAME OVER");
					System.exit(0);
				}

				else{
				
				this.calculationForSnakeMoviment();
				this.coordenateyHead--;
				
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKEHEAD;

				
				if(this.apple[coordenatexHead][coordenateyHead]){this.eatApple();}
				else this.snakeBody[coordenatexHead][coordenateyHead]=1;
			}break;

			case 'w':
			
		

				if((coordenatexHead-1)<0||this.snakeBody[coordenatexHead-1][coordenateyHead]>3){
					System.out.println("GAME OVER");
					System.exit(0);
				}

				else {
					
				this.calculationForSnakeMoviment();
				
				this.coordenatexHead--;
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKEHEAD;

				if(this.apple[coordenatexHead][coordenateyHead]){this.eatApple();}
				else this.snakeBody[coordenatexHead][coordenateyHead]=1;
				}break;

			case 's':

				if(coordenatexHead+1==this.size||this.snakeBody[coordenatexHead+1][coordenateyHead]>3){
					System.out.println("GAME OVER");
					System.exit(0);
				}
				else{

				this.calculationForSnakeMoviment();
				this.coordenatexHead++;
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKEHEAD;

				if(this.apple[coordenatexHead][coordenateyHead]){this.eatApple();}
				else this.snakeBody[coordenatexHead][coordenateyHead]=1;
				
			}break; 

			case 'd':

	
				if(coordenateyHead+1==this.size||this.snakeBody[coordenatexHead][coordenateyHead+1]>3){
					System.out.println("GAME OVER");
					System.exit(0);
				}
				else{

				this.calculationForSnakeMoviment();
				this.coordenateyHead++;
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKEHEAD;

				if(this.apple[coordenatexHead][coordenateyHead]){this.eatApple();}
				this.snakeBody[coordenatexHead][coordenateyHead]=1;
				}break; 
				
			default:
			System.out.println("Snake: ¿Què?");
				break;
		}
					
					
	}


	public void print(){
		System.out.println("POINTS: "+this.points);
		System.out.println("GOAL: "+this.goal);

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {

				Square symbol = this.square[i][j];
				switch (symbol) {
					case BOARD:
						System.out.printf("%-4s","·");		
						break;

					case SNAKE:
						System.out.printf("%-4s","■");		
						break; 
				
					case SNAKEHEAD:
						System.out.printf("%-4s","#");
						break; 
					case APPLE:
						System.out.printf("%-4s","@");
						break; 
				
				}
			}System.out.println();
		}


		for (int i = 0; i < apple.length; i++) {
			for (int j = 0; j < apple.length; j++) {
				System.out.print(this.snakeBody[i][j]+" ");
			}System.out.println();
			
		}System.out.println(coordenatexHead+" " +coordenateyHead);
			System.out.println(coordenatexTail+" " +coordenateyTail);

	}

	
	public boolean gameOver() {

		if (this.points == this.goal)return true;
		else return false ;
	}	

}
