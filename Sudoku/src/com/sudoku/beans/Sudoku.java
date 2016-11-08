package com.sudoku.beans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public abstract class Sudoku {

	protected Integer id;
	protected List<Player> players;
	protected Time startedAt;
	protected Time endedAt;
	protected Timer timer;
	protected Integer noOfPlayers;
	protected Player nextMoveBy;
	protected Player winner;
	protected SudokuBoard initialBoardPosition;
	protected SudokuBoard winningCombination;

	public Sudoku(Integer noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
		this.players = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Time getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Time startedAt) {
		this.startedAt = startedAt;
	}

	public Time getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(Time endedAt) {
		this.endedAt = endedAt;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public Integer getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(Integer noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public abstract void addPlayer(Player player);

	public Player getNextMoveBy() {
		return nextMoveBy;
	}

	public void setNextMoveBy(Player nextMoveBy) {
		this.nextMoveBy = nextMoveBy;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public SudokuBoard getInitialBoardPosition() {
		return initialBoardPosition;
	}

	public void setInitialBoardPosition(SudokuBoard initialBoardPosition) {
		this.initialBoardPosition = initialBoardPosition;
	}

	public SudokuBoard getWinningCombination() {
		return winningCombination;
	}

	public void setWinningCombination(SudokuBoard winningCombination) {
		this.winningCombination = winningCombination;
	}

	public abstract void isGameOver();
	public abstract void startGame();

}
