package practice.design.snakesAndLadders;

public interface Observable {
	public void addObserver(Observer observer) ;
	public void removeObserver(Observer observer) ;
	/*
	 * Keeping it a string for now. It could be a IonStruct which can help have
	 * flexibility of different messages without breaking the function structure
	 */
	public void notifyObserver(String eventMessage) ;
}
