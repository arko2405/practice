package com.sudoku.beans;

public class SingleStandardSudoku extends SinglePlayerSudoku {

	public SingleStandardSudoku() {
	}

	@Override
	public void isGameOver() {
		// logic

	}

	@Override
	public void addPlayer(Player player) {
		player.setAssociatedGame(this);
		player.setBoard(new StandardSudokuBoard());
		players.add(player);
		
	}

	@Override
	public void startGame() {
		// logic
		
	}

}
