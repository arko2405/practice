package com.sudoku.controller;

import com.sudoku.beans.Player;
import com.sudoku.beans.Sudoku;

public interface SudokuGameController {
	
	public Sudoku createMultiPlayerGame(Integer noOfPlayer);
	
	public Sudoku createSinglePlayerGame();
	
	public Boolean start(Sudoku sudoku);
	
	public Sudoku end(Sudoku sudoku);
	
	public Boolean isGameOver(Sudoku sudoku);
	
	public Boolean makeMove(Player player , Integer x , Integer y , Integer value);
	
	public Boolean addPlayer(Player player , Sudoku sudoku);

}
