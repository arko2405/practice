package com.sudoku.beans;

public class StandardSudokuPanel extends SudokuPanel {

	public StandardSudokuPanel() {
		noOfRows = 3;
		noOfColumns = 3;
		panel = new SudokuBlock[noOfRows][noOfColumns];
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				panel[i][j] = new StandardSudokuBlock();
			}
		}
		noOfFilledBlock = 0;
		isPanelFull = false;
	}

	@Override
	public void markBlock(Integer row, Integer col, Integer val) {
		panel[row][col].setValue(val);
		panel[row][col].setIsEmty(true);
		noOfFilledBlock++;
		if(noOfFilledBlock == (row * col))
			isPanelFull = true;
	}

}
