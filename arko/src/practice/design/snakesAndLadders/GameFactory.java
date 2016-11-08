package practice.design.snakesAndLadders;

public class GameFactory {
	
	public static Game getGame(String gameName) {
		if (gameName.equals("SnakeAndLadder")) {
			return new SnakeAndLadderGame();
		} else {
			//later we can have some more games..
			return null;
		}
	}
}
