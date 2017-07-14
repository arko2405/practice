package practice.design.snakesAndLadders;

import java.util.Scanner;

public class SnLHumanPlayBehavior extends SnLPlayBehavior {
	Scanner sc;
	
	SnLHumanPlayBehavior (Dice dice) {
		sc = new Scanner(System.in);
		this.dice = dice;
	}
	
	public void play() {
		sc.nextLine(); //wait for player click enter...then perform dice throw
		dice.throwDice();
	}
}
