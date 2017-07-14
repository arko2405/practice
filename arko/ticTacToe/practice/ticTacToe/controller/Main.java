package practice.ticTacToe.controller;

import java.util.Scanner;

import practice.ticTactToe.beans.Coordinate;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TicTacToeGameController controller = new TicTacToeGameController();
		System.out.println("Enter player name <space> symbol");
		controller.createAndAddPlayer(sc.next(),sc.next());
		controller.createAndAddPlayer(sc.next(),sc.next());
		controller.setCurrentPlayer(controller.getPlayers().get(0));
		controller.setLastMoveBy(controller.getPlayers().get(1));

		int i = 0;
		for ( i = 0; i < 9; i++) {
			
			controller.getTicTacToeBoard().printBoard();
			System.out.println(controller.getCurrentPlayer().getName()+"'s move");
			// take input for player
			Coordinate point1 = new Coordinate(sc.nextInt(), sc.nextInt());
			// PLayer1 hitting player2's board
			controller.markAtBoard(point1, controller.getCurrentPlayer());
			if (controller.isGameOver()) {
				controller.getTicTacToeBoard().printBoard();
				System.out.println("Congratulations "+controller.getLastMoveBy().getName() + "!! You have won the game");
				break;
			}

		}
		if(i==9)
			System.out.println("Tied");

	}

}
