package practice.design.snakesAndLadders;

public class App {
	public static void main(String args[]) {
		Game game = GameFactory.getGame("SnakeAndLadder");
		((SnakeAndLadderGame)game).addPlayers();
		((SnakeAndLadderGame)game).addObserver(new GameEventPublisher());
		((SnakeAndLadderGame)game).printBoard();
		game.startGame();
	}
}
