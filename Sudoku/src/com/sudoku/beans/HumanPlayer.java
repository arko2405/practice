package com.sudoku.beans;

public class HumanPlayer extends Player {

	public HumanPlayer(Sudoku associatedGame) {
		super(associatedGame);
		
	}

	@Override
	public void markBlock(Integer x, Integer y, Integer val) {
		board.markBlock(x, y, val);

	}

}
