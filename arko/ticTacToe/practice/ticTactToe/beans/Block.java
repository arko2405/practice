package practice.ticTactToe.beans;

public class Block {

	private Player associatedPlayer;
	private Boolean isMarked;
	
	public Block() {
		this.isMarked = false;
	}

	public Player getAssociatedPlayer() {
		return associatedPlayer;
	}

	private void setAssociatedPlayer(Player associatedPlayer) {
		this.associatedPlayer = associatedPlayer;
	}

	public Boolean isMarked() {
		return isMarked;
	}

	public void mark(Player player) {
		this.isMarked = true;
		setAssociatedPlayer(player);
	}
	
}
