package practice.design.snakesAndLadders;

public class SnakeAndLadderBoard implements Board2D {

	SnakeAndLadderBoardCell board[][];
	int numOfRow;
	int numOfCol;
	SnLGameStrategy gameStrategy;
	
	SnakeAndLadderBoard(int rows, int cols, SnLGameStrategy gameStrategy) {
		numOfRow = rows;
		numOfCol = cols;
		this.gameStrategy = gameStrategy;
		board = new SnakeAndLadderBoardCell[rows][cols];
	}
	
	public void initBoard() {
		gameStrategy.initBoard();
		gameStrategy.putSnakesAndLaddersOnBoard();
	}
	public SnakeAndLadderBoardCell getCoordinateXAhead(Coordinate currentPosition, int X) {
		SnakeAndLadderBoardCell finalCell = gameStrategy.getCoordinateOfCellXAhead(board[currentPosition.x][currentPosition.y], X);
		if (finalCell.objectPlaceholder instanceof Snake) {
			Snake s = (Snake) finalCell.objectPlaceholder;
			if (s.isHead(finalCell.coordinate)) {
				Coordinate c = s.tailPosition;
				return board[c.x][c.y];
			}
		} else if (finalCell.objectPlaceholder instanceof Ladder) {
			Ladder l = (Ladder) finalCell.objectPlaceholder;
			if (l.isEnd(finalCell.coordinate)) {
				Coordinate c = l.startPosition;
				return board[c.x][c.y];
			}
		}
		return finalCell;
	}
	
	@Override
	public int getNumOfRows() {
		return numOfRow;
	}

	@Override
	public int getNumOfColumns() {
		return numOfCol;
	}

	@Override
	public int getNumOfCellsInBoard() {
		return numOfRow*numOfCol;
	}

	@Override
	public boolean validateTheCoordinates(Coordinate coordinate) {
		if (coordinate.x <numOfRow && coordinate.x >= 0 && coordinate.y <numOfCol && coordinate.y >=0 ) {
			return true;
		}
		return false;
	}
}
