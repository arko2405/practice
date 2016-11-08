package practice.design.snakesAndLadders;

public abstract class SnLGameStrategy {
	SnakeAndLadderBoard SnLBoard;
	
	SnLGameStrategy (SnakeAndLadderBoard board) {
		this.SnLBoard = board;  
	}

	public abstract void initBoard();
	public abstract void putSnakesAndLaddersOnBoard();
	public abstract boolean isEndCell(SnakeAndLadderBoardCell cell);
	public abstract SnakeAndLadderBoardCell getEndCell();
	public abstract boolean isStartCell(SnakeAndLadderBoardCell cell);
	public abstract SnakeAndLadderBoardCell getStartCell();
	public abstract SnakeAndLadderBoardCell getCoordinateOfCellXAhead(SnakeAndLadderBoardCell currentCell, int x);
}
