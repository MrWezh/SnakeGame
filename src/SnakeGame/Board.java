package SnakeGame;
import java.util.Random;

public class Board {
	private int size; 
	private Square[][] square;
	private boolean[][] apple;
	private int[][] snakeBody; 

	private int coordenatexHead;
	private int coordenateyHead;

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

	

	public void setPoints(int points) {
		this.points = points;
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
					if(this.snakeBody[i][j]>(3+points))
					{this.snakeBody[i][j] = 0;this.square[i][j] = Square.BOARD;}
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

	private void gameLose(int coordenate, int x, int y, boolean option){
		
				if (option&&(coordenate - 1 < 0 || 
				this.snakeBody[coordenatexHead + x][coordenateyHead + y] > 1)) {
					System.out.println("GAME OVER");
					System.exit(0);
				}
				else if (!option&&(coordenate + 1 == this.size ||
						this.snakeBody[coordenatexHead + x][coordenateyHead + y] > 1)) {
					System.out.println("GAME OVER");
					System.exit(0);
				}

		}
	
	
	
	public void snakeMovement(char input) {

		this.calculationForSnakeMoviment();

		switch (input) {
			case 'a':
			
				gameLose(coordenateyHead, 0, -1, true);	
				this.coordenateyHead--;

				break;

			case 'w':
			
				gameLose(coordenatexHead, -1, 0, true);
				this.coordenatexHead--;

				break;

			case 's':

				gameLose(coordenatexHead, +1, 0, false);
				this.coordenatexHead++;
				
			break; 

			case 'd':

				gameLose(coordenateyHead, 0, +1, false);
				this.coordenateyHead++;

				break; 
				
			default:
			System.out.println("Snake: ¿Què?");
				break;
		}

		if (this.apple[coordenatexHead][coordenateyHead]) {
			this.eatApple();
		} 
		
		else{
			this.snakeBody[coordenatexHead][coordenateyHead] = 1;
		}
		this.square[coordenatexHead][coordenateyHead] = Square.SNAKEHEAD;
			
	}


	public void print(){
		System.out.println("POINTS: "+this.points);
		System.out.println("GOAL: "+this.goal);

		System.out.print("╔");
		for (int i = -1; i < apple.length*2; i++) {
				System.out.print("═");			
		}System.out.println("╗");

		for (int i = 0; i < this.size; i++) {
			System.out.print("║");
			for (int j = 0; j < this.size; j++) {

				Square symbol = this.square[i][j];
				switch (symbol) {
					case BOARD:
						if(j==this.size-1)System.out.print("   ");
						else System.out.printf("%-2s","  ");		
						break;

					case SNAKE:
						if (j == this.size - 1)
							System.out.print(" ■ ");
						else
							System.out.printf("%-2s"," ■");		
						break; 
				
					case SNAKEHEAD:
						if (j == this.size - 1)
							System.out.print(" # ");
						else	
							System.out.printf("%-2s"," #");
						break; 
					case APPLE:
						if (j == this.size - 1)
							System.out.print(" @ ");
						else
							System.out.printf("%-2s"," @");
						break; 
				
				}
			}
			System.out.println("║");
		}
		System.out.print("╚");
		for (int i = -1; i < this.size*2; i++) {
			System.out.print("═");
		}
		System.out.println("╝");

	}

	
	public boolean gameWin() {

		if (this.points == this.goal)return true;
		else return false ;
	}	

}
