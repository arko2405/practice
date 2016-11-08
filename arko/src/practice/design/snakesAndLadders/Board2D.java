package practice.design.snakesAndLadders;

public interface Board2D {
	public int getNumOfRows();
	public int getNumOfColumns();
	public int getNumOfCellsInBoard();
	public boolean validateTheCoordinates(Coordinate coordinate);
}
