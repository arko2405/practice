package practice.design.warshipGame;

public class WaterBlock implements Block {
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean isOccupied() {
		return true;
	}
}
