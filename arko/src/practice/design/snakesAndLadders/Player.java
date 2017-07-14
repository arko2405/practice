package practice.design.snakesAndLadders;

public abstract class Player {
	String playerName;
	String dateOfBirth;
	long score;

	/*
	 * Design Principle says extract the things that can change.
	 * Lets say in ludo, someone will play it anticlockwise, other play it clockwise.
	 * 
	 * Another example of chess, some play can play it with expert algo, other
	 * may play it with amateur algo It depends on the playing behavior.
	 */
	PlayBehavior playBehavior;

	public void setPlayBehavior(PlayBehavior playBehavior) {
		this.playBehavior = playBehavior;
	}
	
	public void play() {
		playBehavior.play();
	}
}
