package SnakeGame;
import java.util.*;

public class Board {
	private int size; 
	private Square[][] square;
	private ArrayList<Square> snakeBody; 
	private boolean[][] apple;


	private int coordenatexHead;
	private int coordenateyHead;

	private int coordenatexTail;
	private int coordenateyTail;

	private int points; 

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	


	private void randomGenerateApple() {
		
		Random random = new Random();

        for (int i = 0; i < 1; i++) {
        int CoordenadaXRadoms = random.nextInt(this.size);
        int CoordenadaYRadoms = random.nextInt(this.size);

        if (this.square[CoordenadaXRadoms][CoordenadaYRadoms]==Square.BOARD){this.apple[CoordenadaXRadoms][CoordenadaYRadoms] = true; 
        this.square[CoordenadaXRadoms][CoordenadaYRadoms] = Square.APPLE; }
		else i--;
        }
		
	}
	
	public void initBoard() {
		square = new Square[this.size][this.size];
		snakeBody = new ArrayList<Square>(); 
		apple = new boolean[this.size][this.size];

		this.init();
		this.randomGenerateApple();

		
	}
	
	public void init(){
		
			// Inicializar el cuerpo de la serpiente
			for (int i = 0; i < 3; i++) {

				 if (i < 2)
					snakeBody.add(Square.SNAKE);
				else{
					snakeBody.add(Square.SNAKEHEAD);}
			}

			snakeBody.set(0, Square.SNAKETAIL);


			//Iniciarizar Tablero

			for (int i = 0; i < square.length; i++) {
				for (int j = 0; j < square[0].length; j++) {
					this.square[i][j] = Square.BOARD; 
				}
			}

			// Colocar la serpiente en la columna central del tablero
			// Colocar la serpiente en el tablero
			int row = this.size / 2;
			int column = 0;

			for (Square symbol : snakeBody) {

				if(symbol==Square.SNAKEHEAD){
					this.coordenatexHead = row;
					this.coordenateyHead = column;
				}
				if(symbol==Square.SNAKETAIL){
					this.coordenatexTail = row;
					this.coordenateyTail = column;
				}

				this.square[row][column++] = symbol;

				

			}
		
		

		}
	
	public void snakeMovement(char input) {
		

		switch (input) {
			case 'a':
			if((coordenateyHead-1)>=0&&this.square[coordenatexHead][coordenateyHead-1]!=Square.SNAKE){

				if(this.square[coordenatexHead][coordenateyHead-1]!=Square.SNAKE||this.square[coordenatexHead][coordenateyHead-1]!=Square.SNAKETAIL){
					System.out.println("YOU'RE DIED");
				}
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKE;
				this.coordenateyHead--;
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKEHEAD;

				if(this.apple[coordenatexHead][coordenateyHead]){
					this.points++;
				}
				else this.placeSnakeTail();
			}
				break;

			case 'w':
			if((coordenatexHead-1)>=0&&this.square[coordenatexHead-1][coordenateyHead]!=Square.SNAKE){
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKE;
				this.coordenatexHead--;
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKEHEAD;

				if(this.apple[coordenatexHead][coordenateyHead]){
					this.points++;
				}
				else this.placeSnakeTail();
			}

				break;

			case 's':
			if((coordenatexHead+1)<this.size&&this.square[coordenatexHead+1][coordenateyHead]!=Square.SNAKE){
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKE;
				this.coordenatexHead++;
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKEHEAD;

				if(this.apple[coordenatexHead][coordenateyHead]){
					this.points++;
				}
				else this.placeSnakeTail();
			}
				break; 

			case 'd':

			if((coordenateyHead+1)<this.size&&this.square[coordenatexHead][coordenateyHead+1]!=Square.SNAKE){
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKE;
				this.coordenateyHead++;
				this.square[coordenatexHead][coordenateyHead]=Square.SNAKEHEAD;

				if(this.apple[coordenatexHead][coordenateyHead]){
					this.points++;
				}
				else this.placeSnakeTail();
			}

				break; 
				
		
			default:
			System.out.println("Snake: ¿Què?");
				break;
		}
					
					
	}


	private void placeSnakeTail(){

		int i = coordenatexTail;
		int j = coordenateyTail;
		
		this.square[i][j] = Square.BOARD;

		if (i+1<this.size&&this.square[i+1][j] == Square.SNAKE){this.square[i+1][j]=Square.SNAKETAIL;this.coordenatexTail++;}
		if (i-1 >= 0&&this.square[i-1][j] == Square.SNAKE){this.square[i-1][j]=Square.SNAKETAIL;this.coordenatexTail--;}
		if (j+1<this.size&&this.square[i][j+1] == Square.SNAKE){this.square[i][j+1]=Square.SNAKETAIL;this.coordenateyTail++;}
		if (j-1 >= 0&&this.square[i][j-1] == Square.SNAKE){this.square[i][j-1]=Square.SNAKETAIL;this.coordenateyTail--;}
		

	}
	
	private boolean eatApple(){
		if(this.apple[coordenatexHead][coordenateyHead]){
			return true;
		}else return false; 
	}
	

	public void print(){
		System.out.println("POINTS: "+points);

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
					case SNAKETAIL:
						System.out.printf("%-4s","■");
				
				}
			}System.out.println();
		}


		for (int i = 0; i < apple.length; i++) {
			for (int j = 0; j < apple.length; j++) {
				System.out.print(this.square[i][j]+" ");
			}System.out.println();
			
		}System.out.println(coordenatexHead+" " +coordenateyHead);
			System.out.println(coordenatexTail+" " +coordenateyTail);

	}

	
	public boolean LoseGame(boolean gameOver) {

		if (!gameOver)return true;
		else return false ;
	}
	
	

}
