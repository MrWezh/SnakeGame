package SnakeGame;

import java.util.*;

public class Board {
	private int size; 
	private int column;
	private Square[][] square;
	private ArrayList<Square> snakeBody; 
	private boolean[][] apple;
	
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	private void randomGenerateApple() {
		
		Random random = new Random();

        for (int i = 0; i < 1; i++) {
        int CoordenadaXRadoms = random.nextInt(this.size);
        int CoordenadaYRadoms = random.nextInt(this.column);

        if (this.square[CoordenadaXRadoms][CoordenadaYRadoms]==Square.BOARD){this.apple[CoordenadaXRadoms][CoordenadaYRadoms] = true; 
        this.square[CoordenadaXRadoms][CoordenadaYRadoms] = Square.APPLE; }
		else i--;
        }
		
	}
	
	public void initBoard() {
		square = new Square[this.size][this.column];
		snakeBody = new ArrayList<Square>(); 
		apple = new boolean[this.size][this.column];

		this.init();
		this.randomGenerateApple();
		


		
	}
	
	public void init(){
		
			// Inicializar el cuerpo de la serpiente
			for (int i = 0; i < 3; i++) {
				if (i < 2)
					snakeBody.add(Square.SNAKE);
				else
					snakeBody.add(Square.SNAKEHEAD);
			}
		
			// Colocar la serpiente en el tablero
			for (int i = 0; i <this.size; i++) {
				for (int j = 0; j < this.column; j++) {
					this.square[i][j] = Square.BOARD;
					this.apple[i][j] = false;
				}
			}
		
			// Colocar la serpiente en la columna central del tablero
			
			int row = this.size / 2;
			int column = 0;
			for (Square symbol : snakeBody) {
				this.square[row][column++] = symbol;

			}
		
		

		}


	
	
	
	public void snakeMovement() {
		
	}
	
	public void print(){

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.column; j++) {
				Square symbol = this.square[i][j];
				switch (symbol) {
					case BOARD:
						System.out.printf("·");		
						break;

					case SNAKE:
						System.out.print("■");		
						break; 
				
					case SNAKEHEAD:
						System.out.print("C");
						break; 
					case APPLE:
						System.out.print("@");
						break; 
				
				}
			}System.out.println();
		}

	}
	
	public boolean winGame() {
			
		return true;
	}
	
	public boolean LoseGame() {
		
		return true; 
	}
	
	

}
