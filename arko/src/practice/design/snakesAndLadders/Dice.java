package practice.design.snakesAndLadders;

import java.util.Random;

/**
 * Its nothing but a container of n numbers 1 to n.
 * Generally 1 to 6
 * @author Virus17
 */
public class Dice {
	Random random;
	int maxNum;
	int diceState;
	
	Dice(int max) {
		random = new Random();
		maxNum = max;
		diceState = -1;
	}
	
	public void throwDice() {
		throwDiceRandomly();
	}
	
	public void throwDiceRandomly() {
		//random.nextInt returns number from 0 to maxNum-1
		diceState = random.nextInt(maxNum) + 1;  
	}
}
