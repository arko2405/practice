package practice.design.snakesAndLadders;

public abstract class SnLPlayBehavior implements PlayBehavior {
	/*
	 * Dice Object will be distributed by the game. Game can give the same Dice
	 * object to all the players or different dice object
	 */
	Dice dice;
}
