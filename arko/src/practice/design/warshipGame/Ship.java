package practice.design.warshipGame;

import java.util.List;

public class Ship {
	private ShipBlock shipBlocks[];
	private int shipLength;
	private int hitCount; //depends on shipBlocks hit count
	private int noOfBlocksDamaged;
	private Player associatedPlayer;
	private WaterBoard associatedBoard;

	Ship(int shipLength, List<Integer> damageIndexes) {
		this.shipLength = shipLength;
		shipBlocks = new ShipBlock[shipLength];
		noOfBlocksDamaged = 0;
		for (int i=0;i<shipLength;i++) {
			shipBlocks[i] = new ShipBlock(damageIndexes.get(i), this);
		}
	}
	
	public boolean isShipDown () {
		return (noOfBlocksDamaged == shipLength);
	}
	
	public int getNoOfBlocksDamaged() {
		return noOfBlocksDamaged;
	}

	public void setNoOfBlocksDamaged(int noOfBlocksDamaged) {
		this.noOfBlocksDamaged = noOfBlocksDamaged;
	}

	public ShipBlock[] getShipBlocks() {
		return shipBlocks;
	}

	public void setShipBlocks(ShipBlock[] shipBlocks) {
		this.shipBlocks = shipBlocks;
	}

	public int getShipLength() {
		return shipLength;
	}

	public void setShipLength(int shipLength) {
		this.shipLength = shipLength;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public Player getAssociatedPlayer() {
		return associatedPlayer;
	}

	public void setAssociatedPlayer(Player associatedPlayer) {
		this.associatedPlayer = associatedPlayer;
	}

	public WaterBoard getAssociatedBoard() {
		return associatedBoard;
	}

	public void setAssociatedBoard(WaterBoard associatedBoard) {
		this.associatedBoard = associatedBoard;
	}

}
