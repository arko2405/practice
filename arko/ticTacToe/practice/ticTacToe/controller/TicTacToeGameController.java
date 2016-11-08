package practice.ticTacToe.controller;

import java.util.ArrayList;
import java.util.List;

import practice.ticTactToe.beans.Board;
import practice.ticTactToe.beans.Coordinate;
import practice.ticTactToe.beans.Player;

public class TicTacToeGameController {

	private Board ticTacToeBoard;
	private List<Player> players ;
	private Boolean isGameOver;
	private Player lastMoveBy;
	private Player currentPlayer;
	
	public TicTacToeGameController() {
		this.ticTacToeBoard = new Board(3);
		this.players = new ArrayList<>();
		this.isGameOver=false;
	}
	
	public void createAndAddPlayer(String name) {
		players.add(new Player(name));
	}
	public void createAndAddPlayer(String name,String symbol) {
		players.add(new Player(name,symbol));
	}
	
	public Boolean markAtBoard(Coordinate coordinate,Player player) {
		Boolean marked = ticTacToeBoard.mark(coordinate, player);
		if(marked==true){
			checkAndSetGameOver(coordinate);
			setCurrentPlayer(lastMoveBy);
			setLastMoveBy(player);
		}
		return marked;
	}

	private void checkAndSetGameOver(Coordinate coordinate) {
		if ((ticTacToeBoard.getBlocks()[0][coordinate.getY()].getAssociatedPlayer() == ticTacToeBoard.getBlocks()[1][coordinate.getY()].getAssociatedPlayer() )
			&& (ticTacToeBoard.getBlocks()[1][coordinate.getY()].getAssociatedPlayer()  == ticTacToeBoard.getBlocks()[2][coordinate.getY()].getAssociatedPlayer() )
			&& (ticTacToeBoard.getBlocks()[0][coordinate.getY()].getAssociatedPlayer()  != null))
				setIsGameOver(true);
				
		if ((ticTacToeBoard.getBlocks()[coordinate.getX()][0].getAssociatedPlayer()  == ticTacToeBoard.getBlocks()[coordinate.getX()][1].getAssociatedPlayer() )
			&& (ticTacToeBoard.getBlocks()[coordinate.getX()][1].getAssociatedPlayer()  == ticTacToeBoard.getBlocks()[coordinate.getX()][2].getAssociatedPlayer() )
			&& (ticTacToeBoard.getBlocks()[coordinate.getX()][0].getAssociatedPlayer()  != null))
			setIsGameOver(true);
			
		if (coordinate.getX() == coordinate.getY()) {
			if ((ticTacToeBoard.getBlocks()[0][0].getAssociatedPlayer()  == ticTacToeBoard.getBlocks()[1][1].getAssociatedPlayer() )
				&& (ticTacToeBoard.getBlocks()[1][1].getAssociatedPlayer()  == ticTacToeBoard.getBlocks()[2][2].getAssociatedPlayer() )
				&& (ticTacToeBoard.getBlocks()[0][0].getAssociatedPlayer()  != null))
				setIsGameOver(true);
			}
		
		if (coordinate.getX() == 2-coordinate.getY()) {
			if ((ticTacToeBoard.getBlocks()[0][2].getAssociatedPlayer()  == ticTacToeBoard.getBlocks()[1][1].getAssociatedPlayer() )
				&& (ticTacToeBoard.getBlocks()[1][1].getAssociatedPlayer()  == ticTacToeBoard.getBlocks()[2][0].getAssociatedPlayer() )
				&& (ticTacToeBoard.getBlocks()[0][2].getAssociatedPlayer()  != null))
				setIsGameOver(true);
			}
		
	}

	public Boolean isGameOver() {
		return isGameOver;
	}

	private void setIsGameOver(Boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public Player getLastMoveBy() {
		return lastMoveBy;
	}

	public void setLastMoveBy(Player lastMoveBy) {
		this.lastMoveBy = lastMoveBy;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Board getTicTacToeBoard() {
		return ticTacToeBoard;
	}
	
	
}
