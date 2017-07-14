package practice.design.snakesAndLadders;

public class SnakeAndLadderPlayer extends Player {

	Coordinate playerPosition;
	boolean hasWon;
	long countOfSnakeBite, countOfStairClimb;

	SnakeAndLadderPlayer(PlayBehavior playBehavior) {
		hasWon = false;
		countOfSnakeBite = 0;
		countOfStairClimb = 0;
		playerPosition = new Coordinate(0,0);
		setPlayBehavior(playBehavior);
	}

	public Coordinate getPosition() {
		return playerPosition;
	}
	
	public void setPosition(Coordinate c) {
		this.playerPosition = c;
	}
	
	public void performDiceThrow() {
		playBehavior.play();
	}
}
