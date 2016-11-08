package practice.ticTactToe.beans;

public class Board {

	private Block[][] blocks;
	private int size;
	

	public Board(int size) {
		this.blocks = new Block[size][size];
		this.size = size;
		initBoard();
	}

	public Block getBlockAt(Coordinate coordinate) {
		return blocks[coordinate.getX()][coordinate.getY()];
	}
	
	
	
	public Block[][] getBlocks() {
		return blocks;
	}

	private void initBoard() {
		for (int i=0;i<this.size;i++) {
			for (int j=0;j<this.size;j++) {
				blocks[i][j] = new Block();
			}
		}
	}
	
	public boolean mark(Coordinate coordinate,Player player) {
		if(!blocks[coordinate.getX()][coordinate.getY()].isMarked()){
			blocks[coordinate.getX()][coordinate.getY()].mark(player);
			return true;
		}
		return false;
	}
	
	public void printBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < blocks.length; j++) {
				String name = blocks[i][j].getAssociatedPlayer()!=null?blocks[i][j].getAssociatedPlayer().getSymbol():"_";
				System.out.print(name+"\t");
			}
			System.out.println();
		}
	}
	
}
