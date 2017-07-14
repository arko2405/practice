package practice.design.warshipGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final String playerName;
	private final long playerId;
	private WaterBoard playerBoard;
	private List<Ship> ships;
	
	Player (String name, long id) {
		this.playerName = name;
		this.playerId = id;
		ships =  new ArrayList<Ship>();
	}
	
	public WaterBoard getPlayerBoard() {
		return playerBoard;
	}

	public void setPlayerBoard(WaterBoard playerBoard) {
		this.playerBoard = playerBoard;
	}
	
	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public String getPlayerName() {
		return playerName;
	}

	public long getPlayerId() {
		return playerId;
	}
	
	public int getNoOfShips() {
		return ships.size();
	}
	
	public void addShip(Ship s) {
		ships.add(s);
	}
}
