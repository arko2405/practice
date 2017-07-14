package practice.design.snakesAndLadders;

public class SnLComputerPlayBehavior extends SnLPlayBehavior {
	
	SnLComputerPlayBehavior (Dice dice) {
		this.dice = dice;
	}
	
	public void play() {
		dice.throwDice();
	}
}
