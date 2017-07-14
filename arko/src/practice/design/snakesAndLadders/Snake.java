package practice.design.snakesAndLadders;

public class Snake implements Object {
	Coordinate headPosition;
	Coordinate tailPosition;
	
	Snake(Coordinate headPosition, Coordinate tailPosition) {
		this.headPosition = headPosition;
		this.tailPosition = tailPosition;
	}
	
	public void bite(SnakeAndLadderPlayer player) {
		if (canSnakeBiteThePlayer(player) ) {
			player.setPosition(new Coordinate(tailPosition.x, tailPosition.y));
		}
	}
	
	public boolean canSnakeBiteThePlayer(SnakeAndLadderPlayer player) {
		return (headPosition.equals(player.getPosition()));
	}
	
	public boolean isHead(Coordinate coordinate) {
		if(coordinate.equals(headPosition)) {
			return true;
		}
		return false;
	}
	
	public boolean isTail(Coordinate coordinate) {
		if(coordinate.equals(tailPosition)) {
			return true;
		}
		return false;
	}
}
