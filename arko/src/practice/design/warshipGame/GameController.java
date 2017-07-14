package practice.design.warshipGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class currently is very specific...Due to time constaint i have
 * not made it generic
 */
public class GameController {
	private List<Player> players;
	
	GameController() {
		players = new ArrayList<Player>();
	}
	
	public void createAndAddPlayer(String name) {
		players.add(new Player(name, players.size() + 1));
	}
	
	public void associateEmptyBoardWithPlayer(Player p, int n) {
		p.setPlayerBoard(new WaterBoard(n));
	}
	
	public void addShipToPlayersBoard(Player p, Coordinate st, Coordinate end) throws Exception {
		int length  = calculateShipLenth (st, end);
		List<Integer> damageIndexes = new ArrayList<Integer> ();
		for (int i = 0 ; i < length; i++) {
			damageIndexes.add(1);
		}
		
		Ship ship = new Ship(length, damageIndexes);  // can be easily changed

		p.addShip(ship);
		p.getPlayerBoard().placeShip(ship, st, isShipToBePlacedVertical(st, end));
	}
	
	public String hitPlayerAtCoordinates(Player player, Coordinate point, int power) {
		WaterBoard board = player.getPlayerBoard();
		boolean isHit = board.hitBlock(point, power);
		if (isHit) {
			ShipBlock shipBlock = (ShipBlock)board.getBlockAt(point);
			String msg = ("You hit " + player.getPlayerName() + "'s Ship.");
			if (shipBlock.getAssociatedShip().isShipDown()) {
				msg += " One Ship is down";
			}
			return msg;
			
		} else {
			return ("You Missed " + player.getPlayerName() + "'s Ship");
		}
	}

	public boolean isGameOverForPlayer (Player p) {
		boolean allShipDown =true;
		for (Ship ship : p.getShips()) {
			if (!ship.isShipDown()) {
				allShipDown = false;
			}
		}
		return allShipDown;
	}
	
	public Player getPlayerAtIndex(int i) {
		return players.get(i);
	}
	
	private int calculateShipLenth (Coordinate st, Coordinate end) throws Exception {
		if (st.getX() == end.getX()) {
			return (Math.abs(st.getY() - end.getY()) + 1);
		} else if (st.getY() == end.getY()) {
			return (Math.abs(st.getX() - end.getX()) + 1);
		} else {
			throw new Exception ("Ship can either be palced vertically or horizontally");
		}
	}
	private boolean isShipToBePlacedVertical (Coordinate st, Coordinate end) throws Exception {
		if (st.getX() == end.getX()) {
			return true;
		} else if (st.getY() == end.getY()) {
			return false;
		} else {
			throw new Exception ("Ship can either be palced vertically or horizontally");
		}
	}
}
