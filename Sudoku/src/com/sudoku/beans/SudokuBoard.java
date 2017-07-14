package com.sudoku.beans;

public abstract class SudokuBoard {

	protected Integer id;
	protected Integer noOfRows;
	protected Integer noOfColumns;
	protected SudokuPanel board[][];
	protected Integer noOfFilledPanel;
	protected Boolean isBoardFull;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNoOfRows() {
		return noOfRows;
	}

	public void setNoOfRows(Integer noOfRows) {
		this.noOfRows = noOfRows;
	}

	public Integer getNoOfColumns() {
		return noOfColumns;
	}

	public void setNoOfColumns(Integer noOfColumns) {
		this.noOfColumns = noOfColumns;
	}

	public SudokuPanel[][] getBoard() {
		return board;
	}

	public void setBoard(SudokuPanel[][] board) {
		this.board = board;
	}

	public Integer getNoOfFilledPanel() {
		return noOfFilledPanel;
	}

	public void setNoOfFilledPanel(Integer noOfFilledPanel) {
		this.noOfFilledPanel = noOfFilledPanel;
	}

	public Boolean getIsBoardFull() {
		return isBoardFull;
	}

	public void setIsBoardFull(Boolean isBoardFull) {
		this.isBoardFull = isBoardFull;
	}

	public abstract void markBlock(Integer x, Integer y, Integer val);

}
