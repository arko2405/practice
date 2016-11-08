package practice.design.snakesAndLadders;

public interface Game {
	public void startGame();
	public void restartGame();
	public void pauseGame();
	public void resumeGame();
	public void endGame();
	
	public void addPlayers();
}
