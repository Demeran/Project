import java.util.LinkedList;

public class Wagon {
	boolean isHeader;
	LinkedList <Passengers> wagon = new LinkedList<>(); //Вагоны для пассажиров
	public Wagon(boolean isHeader) {
		
		super();
		this.isHeader = isHeader;
		}
	static int maxpassengersvalue=50;
}
