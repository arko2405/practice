package practice.design.snakesAndLadders;

public class SnLNormalGameStrategy extends SnLGameStrategy {

	SnLNormalGameStrategy(SnakeAndLadderBoard board) {
		super(board);
	}

	// x,y coordinates in normal is differnt from i,j in array.. its reverse so dont get confused
	@Override
	public void initBoard() {
		SnakeAndLadderBoardCell prev = null;
		for (int i = 0; i < SnLBoard.getNumOfRows(); i++) {
			int cols = SnLBoard.getNumOfColumns();
			int j = initJGivenI(i, cols);

			while (conditionOfJ(i, j, 0, cols)) {
				SnakeAndLadderBoardCell cell = new SnakeAndLadderBoardCell();
				cell.coordinate = new Coordinate(i, j);
				cell.cellNum = (i * SnLBoard.getNumOfColumns()) + (j + 1);
				if (prev != null) {
					prev.next = cell;
				}
				prev = cell;
				SnLBoard.board[i][j] = cell;

				j = nextJGivenI(i, j);
			}
		}
	}

	@Override
	public void putSnakesAndLaddersOnBoard() {
		// For now.. hardcoding.. assuming 5*5
		Snake s = new Snake(new Coordinate(3, 3), new Coordinate(0, 2));
		SnLBoard.board[3][3].objectPlaceholder = s;
		SnLBoard.board[0][2].objectPlaceholder = s;
		s = new Snake(new Coordinate(4, 3), new Coordinate(2, 2));
		SnLBoard.board[4][3].objectPlaceholder = s;
		SnLBoard.board[2][2].objectPlaceholder = s;
		s = new Snake(new Coordinate(4, 1), new Coordinate(1, 2));
		SnLBoard.board[4][1].objectPlaceholder = s;
		SnLBoard.board[1][2].objectPlaceholder = s;
		
		Ladder l = new Ladder(new Coordinate(3, 2), new Coordinate(1, 0));
		SnLBoard.board[3][2].objectPlaceholder = l;
		SnLBoard.board[1][0].objectPlaceholder = l;
		l = new Ladder(new Coordinate(4, 0), new Coordinate(2, 0));
		SnLBoard.board[4][0].objectPlaceholder = l;
		SnLBoard.board[2][0].objectPlaceholder = l;
		l = new Ladder(new Coordinate(3, 4), new Coordinate(1, 4));
		SnLBoard.board[3][4].objectPlaceholder = l;
		SnLBoard.board[1][4].objectPlaceholder = l;
	}

	@Override
	public boolean isEndCell(SnakeAndLadderBoardCell cell) {
		return (cell.coordinate.x == SnLBoard.getNumOfRows() - 1 && cell.coordinate.y == SnLBoard
				.getNumOfColumns() - 1);
	}

	@Override
	public SnakeAndLadderBoardCell getEndCell() {
		return SnLBoard.board[SnLBoard.getNumOfRows()-1][SnLBoard.getNumOfColumns()-1];
	}
	
	@Override
	public boolean isStartCell(SnakeAndLadderBoardCell cell) {
		return (cell.coordinate.x == 0 && cell.coordinate.y == 0);
	}

	@Override
	public SnakeAndLadderBoardCell getStartCell() {
		return SnLBoard.board[0][0];
	}
	
	@Override
	public SnakeAndLadderBoardCell getCoordinateOfCellXAhead(
			SnakeAndLadderBoardCell currentCell, int x) {
		int len = x;
		SnakeAndLadderBoardCell temp = currentCell;
		while (len > 0) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
			len--;
		}
		// Player cant move ahead since num of cells ahead is less than x
		if (len > 0) {
			return currentCell;
		}
		return temp;
	}

	private int initJGivenI(int i, int last) {
		if (i % 2 == 0) {
			return 0;
		} else {
			return last - 1;
		}
	}

	private int nextJGivenI(int i, int j) {
		if (i % 2 == 0) {
			return ++j;
		} else {
			return --j;
		}
	}

	private boolean conditionOfJ(int i, int j, int first, int last) {
		if (i % 2 == 0) {
			return (j < last);
		} else {
			return (j >= first);
		}
	}
}
