package practice.design.snakesAndLadders;

public class SnakeAndLadderBoardCell {

	Coordinate coordinate; // x,y of this cell
	SnakeAndLadderBoardCell next; // x,y of next cell
	int cellNum; // CellNumber
	// placeholder for keeping either snakes head/tail or ladder start/end
	// We cannot have more than one object in one cell. Atleast have that
	// constraint for now.
	Object objectPlaceholder;
	
	SnakeAndLadderBoardCell() {
		coordinate = null;
		next = null;
		objectPlaceholder = null;
	}
}
