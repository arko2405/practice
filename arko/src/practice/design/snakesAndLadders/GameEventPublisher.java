package practice.design.snakesAndLadders;

/**
 * Command Line Game Event Details Printer
 * @author Virus17
 */
public class GameEventPublisher implements Observer {

	@Override
	public void onNotify(String eventMessage) {
		System.out.println(eventMessage);
	}
}
