package com.sudoku.beans;

import java.sql.Time;

public abstract class Player {

	protected Integer id;
	protected String name;
	protected SudokuBoard board;
	protected Time startedAt;
	protected Time lastMovedAt;
	protected Sudoku associatedGame;

	public Player(Sudoku associatedGame) {
		this.associatedGame = associatedGame;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SudokuBoard getBoard() {
		return board;
	}

	public void setBoard(SudokuBoard board) {
		this.board = board;
	}

	public Time getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Time startedAt) {
		this.startedAt = startedAt;
	}

	public Time getLastMovedAt() {
		return lastMovedAt;
	}

	public void setLastMovedAt(Time lastMovedAt) {
		this.lastMovedAt = lastMovedAt;
	}

	public Sudoku getAssociatedGame() {
		return associatedGame;
	}

	public void setAssociatedGame(Sudoku associatedGame) {
		this.associatedGame = associatedGame;
	}

	public abstract void markBlock(Integer x, Integer y, Integer val);

}
