package practice.design.snakesAndLadders;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderGame implements Observable, Game {
	Queue<SnakeAndLadderPlayer> gamePlayersQueue;
	SnakeAndLadderBoard board;
	Dice dice;
	//List<Snake> snakes;   //Dont need it here..
	//List<Ladder> ladders;  //Done need it here..
	/*
	 * These listeners can listen this class events and some other events also.
	 * Thats why its a observer pattern.
	 */
	List<Observer> gameListeners;

	/*
	 * Strategy pattern. We can use any kind of game strategy like square baord
	 * strategy, or zigzag movement strategy or spiral movement strategy.
	 */
	SnLGameStrategy gameStrategy;

	boolean isGameStarted;
	boolean isGamePaused;
	boolean isGameEnded;

	SnakeAndLadderGame() {
		initEveryThing();
	}

	public void setGameStrategy(SnLGameStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
	}

	public void executeNextPlayerTurn() {
	}

	private void initEveryThing() {
		gamePlayersQueue = new LinkedList<SnakeAndLadderPlayer>();
		gameStrategy = new SnLNormalGameStrategy(board);
		board = new SnakeAndLadderBoard(5, 5, gameStrategy);
		gameStrategy.SnLBoard = board; //set board
		board.initBoard();
		dice = new Dice(6); // dice of 6 faces
		gameListeners = new ArrayList<Observer>();
		isGamePaused = false;
		isGameEnded = false;
		isGameStarted = false;
	}

	public void addPlayers() {
		//Adding some players..
		SnakeAndLadderPlayer p1 = new SnakeAndLadderPlayer(new SnLComputerPlayBehavior(dice));
		p1.playerName = "Computer1";
		
		SnakeAndLadderPlayer p2 = new SnakeAndLadderPlayer(new SnLHumanPlayBehavior(dice));
		p2.playerName = "Human1";
		
		//SnakeAndLadderPlayer p3 = new SnakeAndLadderPlayer(new SnLComputerPlayBehavior(dice));
		//p3.playerName = "Computer2";
		
		gamePlayersQueue.add(p1);
		gamePlayersQueue.add(p2);
		//gamePlayersQueue.add(p3);
	}
	
	public void printBoard () {
		printBoardRow(0);	
	}
	
	public void printBoardRow(int r) {
		if (r>=board.numOfRow) {
			return;
		}
		printBoardRow(r+1);
		for (int i=0;i<board.numOfCol;i++) {
			if (board.board[r][i].objectPlaceholder instanceof Snake) {
				System.out.print("S ");
			} else if (board.board[r][i].objectPlaceholder instanceof Ladder) {
				System.out.print("L ");
			} else {
				System.out.print("- ");
			}
			//if (board.board[r][i].next != null) {
			//	System.out.print("->");
			//}
		}
		System.out.println();
	}
	
	@Override
	public void startGame() {
		isGameStarted = true;
		
		notifyObserver("GAME STARTED");
		while (!isGamePaused && !isGameEnded && isGameStarted) {
			SnakeAndLadderPlayer p = gamePlayersQueue.remove();
			notifyObserver("Player " + p.playerName + "'s Turn");
			p.performDiceThrow();
			notifyObserver("DICE STATE = " + dice.diceState);
			p.setPosition(board.getCoordinateXAhead(p.getPosition(), dice.diceState).coordinate);
			notifyObserver("Player " + p.playerName + "'s new Position : " + p.getPosition().toString());
			if (gameStrategy.getEndCell().coordinate.equals(p.getPosition()) ) {
				notifyObserver("Player " + p.playerName + " WON the game");
				isGameEnded = true;
			}
			gamePlayersQueue.add(p);
		}
	}

	@Override
	public void endGame() {
		initEveryThing();
		isGameEnded = true;
		notifyObserver("GAME ENDED");
	}

	@Override
	public void restartGame() {
		initEveryThing();
		isGameStarted = true;
		notifyObserver("GAME RESTARTED");
	}

	@Override
	public void pauseGame() {
		isGamePaused = true;
		notifyObserver("GAME PAUSED");
	}
	
	@Override
	public void resumeGame() {
		isGamePaused = false;
		notifyObserver("GAME RESUMED");
	}

	@Override
	public void addObserver(Observer observer) {
		gameListeners.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		gameListeners.remove(observer);
	}

	@Override
	public void notifyObserver(String eventMessage) {
		for (Observer listener : gameListeners) {
			listener.onNotify(eventMessage);
		}
	}
}
