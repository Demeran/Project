import java.util.LinkedList;
import java.util.Random;

public class Escalator implements Runnable {

	String name;
	LinkedList<Passengers> escalatorStack1;

	Station station1;
	Station station2;
	Random rnd = new Random();
	int passengerID = 1;

	@Override
	public void run() {
		
		
		
		// TODO Auto-generated method stub
		while (true) {
			synchronized (station1.passengers) {
				if (station1.passengers.isEmpty()) {
					try {
						station1.passengers.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Passengers passenger = station1.passengers.poll();
				escalatorStack1.add(passenger);
				
				System.out.println("Пассажир " + passenger  + " проехал по эскалатору " + this.name);
			}

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			station1.platform.add(escalatorStack1.poll());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
	}

	public Escalator(String name, Station station1) {
		super();
		this.name = name;
		this.station1 = station1;
		escalatorStack1 = new LinkedList<>();
	}

}
