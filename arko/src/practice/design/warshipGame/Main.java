package practice.design.warshipGame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		GameController controller = new GameController();
		controller.createAndAddPlayer("Player1");
		controller.createAndAddPlayer("Player2");
		
		int n = sc.nextInt();
		//player1
		controller.associateEmptyBoardWithPlayer(controller.getPlayerAtIndex(0), n);
		//player2
		controller.associateEmptyBoardWithPlayer(controller.getPlayerAtIndex(1), n);
		
		
		int s = sc.nextInt();

		//player 1
		for (int i = 0 ; i< s; i++) {
			Coordinate st = new Coordinate(sc.nextInt(), sc.nextInt());
			Coordinate end = new Coordinate(sc.nextInt(), sc.nextInt());
			
			controller.addShipToPlayersBoard(controller.getPlayerAtIndex(0),st, end);
		}
		
		/*WaterBoard board = controller.getPlayerAtIndex(0).getPlayerBoard();
		for (int i = 0 ; i< n; i++) {
			for (int j = 0 ; j< n; j++) {
				Block block = board.getBlockAt(new Coordinate(i, j));
				if (block instanceof WaterBlock) {
					System.out.print("- ");
				} else {
					System.out.print(((ShipBlock)block).getAssociatedShip());
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		*/
		
		//player 2
		for (int i = 0 ; i< s; i++) {
			Coordinate st = new Coordinate(sc.nextInt(), sc.nextInt());
			Coordinate end = new Coordinate(sc.nextInt(), sc.nextInt());
			
			controller.addShipToPlayersBoard(controller.getPlayerAtIndex(1),st, end);
		}
		
		/*
		System.out.println();System.out.println();System.out.println();System.out.println();
		
		WaterBoard board1 = controller.getPlayerAtIndex(1).getPlayerBoard();
		for (int i = 0 ; i< n; i++) {
			for (int j = 0 ; j< n; j++) {
				Block block = board1.getBlockAt(new Coordinate(i, j));
				if (block instanceof WaterBlock)
					System.out.print("-");
				else
					System.out.print(((ShipBlock)block).getAssociatedShip());
			}
			System.out.println();
		}
		*/
		
		while (true) {
			//take input for player 1 
			Coordinate point1 = new Coordinate(sc.nextInt(), sc.nextInt());
			//PLayer1 hitting player2's board
			String message1 =controller.hitPlayerAtCoordinates(controller.getPlayerAtIndex(1), point1, 1); //with power = 1
			System.out.println(message1);
			//check if its game over for player 2.
			if (controller.isGameOverForPlayer(controller.getPlayerAtIndex(1)) ) {
				System.out.println(controller.getPlayerAtIndex(0).getPlayerName() + " has won the game");
				return;
			}
			
			
			//take input for player 2
			Coordinate point2 = new Coordinate(sc.nextInt(), sc.nextInt());
			//PLayer2 hitting player1's board
			String message2 = controller.hitPlayerAtCoordinates(controller.getPlayerAtIndex(0), point2, 1); //with power = 1
			System.out.println(message2);
			
			//check if its game over for player 1
			if (controller.isGameOverForPlayer(controller.getPlayerAtIndex(0)) ) {
				System.out.println(controller.getPlayerAtIndex(1).getPlayerName() + " has won the game");
				return;
			}
		}
	}

}
