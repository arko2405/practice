package practice.design.warshipGame;

public class WaterBoard {
	private Block blocks2D[][];  // this will either have WaterBlock or ShipBlock
	private int n;
	
	WaterBoard(int n) {
		this.n = n;
		blocks2D = new Block[n][n];
		initWaterBoard();
	}
	public Block getBlockAt(Coordinate point) {
		return blocks2D[point.getX()][point.getY()];
	}
	public boolean hitBlock(Coordinate point, int power) {
		Block block = blocks2D[point.getX()][point.getY()];
		if (block instanceof WaterBlock) {
			//its a miss
			return false;
		} else if (block instanceof ShipBlock){
			//its a hit
			
			ShipBlock shipBlock = (ShipBlock) block;
			shipBlock.hitBlock(power);
			return true;
		} else {
			///throw exception
			return false;
		}
	}
	
	public void placeShip(Ship ship, Coordinate startPointOfShip,  boolean isVertical) {
		/*
		 * 1) check if ship can be placed or not... using coordinates and length of ship.
		 *    throw exception if cant place ship inside the board.
		 * 2) Check if ship is overlapping with any other, throw different exception
		 *  		 
		 */
		
		int x = startPointOfShip.getX();
		int y = startPointOfShip.getY();
		ShipBlock shipBlocks[] = ship.getShipBlocks();
		for (int i = 0; i < ship.getShipLength(); i++) {
			if (isVertical) {
				blocks2D[x][y+i] = shipBlocks[i];
			} else {
				blocks2D[x+i][y] = shipBlocks[i];
			}
		}
		
	}
	
	private void initWaterBoard() {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				blocks2D[i][j] = new WaterBlock();
			}
		}
	}
	
	
}
