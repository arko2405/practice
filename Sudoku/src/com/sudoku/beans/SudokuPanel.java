package com.sudoku.beans;

public abstract class SudokuPanel {

	protected Integer id;
	protected Integer noOfRows;
	protected Integer noOfColumns;
	protected SudokuBlock panel[][];
	protected Integer noOfFilledBlock;
	protected Boolean isPanelFull;

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

	public SudokuBlock[][] getPanel() {
		return panel;
	}

	public void setPanel(SudokuBlock[][] panel) {
		this.panel = panel;
	}

	public Integer getNoOfFilledBlock() {
		return noOfFilledBlock;
	}

	public void setNoOfFilledBlock(Integer noOfFilledBlock) {
		this.noOfFilledBlock = noOfFilledBlock;
	}

	public Boolean getIsPanelFull() {
		return isPanelFull;
	}

	public void setIsPanelFull(Boolean isPanelFull) {
		this.isPanelFull = isPanelFull;
	}

	public abstract void markBlock(Integer row, Integer col, Integer val);

}
