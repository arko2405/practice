package practice.design.snakesAndLadders;

public interface Observer {
	/*
	 * Keeping it a string for now. It could be a IonStruct which can help have
	 * flexibility of different messages without breaking the function structure
	 */
	public void onNotify(String eventMessage);
}
