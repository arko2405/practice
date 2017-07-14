package com.sudoku.beans;

public class StandardSudokuBoard extends SudokuBoard {

	public StandardSudokuBoard() {
		noOfRows = 3;
		noOfColumns = 3;
		board = new SudokuPanel[noOfRows][noOfColumns];
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				board[i][j] = new StandardSudokuPanel();
			}
		}
		noOfFilledPanel = 0;
		isBoardFull = false;
	}

	@Override
	public void markBlock(Integer x, Integer y, Integer val) {
		SudokuPanel panelToMark = board[x/noOfRows][y/noOfColumns];
		panelToMark.markBlock(x%noOfRows, y%noOfColumns, val);
		if(panelToMark.isPanelFull)
			noOfFilledPanel++;
		if(noOfFilledPanel == (noOfRows*noOfColumns))
			isBoardFull = true;
	}

}
