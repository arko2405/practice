package practice.design.snakesAndLadders;

public class Ladder implements Object {
	Coordinate startPosition;
	Coordinate endPosition;
	
	Ladder(Coordinate startPosition, Coordinate endPosition) {
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}
	
	public void climb(SnakeAndLadderPlayer player) {
		if (canPlayerClimbTheLadder(player) ) {
			player.setPosition(new Coordinate(startPosition.x, startPosition.y));
		}
	}
	
	public boolean canPlayerClimbTheLadder(SnakeAndLadderPlayer player) {
		return (endPosition.equals(player.getPosition()));
	}
	
	public boolean isStart(Coordinate coordinate) {
		if(coordinate.equals(startPosition)) {
			return true;
		}
		return false;
	}
	
	public boolean isEnd(Coordinate coordinate) {
		if(coordinate.equals(endPosition)) {
			return true;
		}
		return false;
	}
}
