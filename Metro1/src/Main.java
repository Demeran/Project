import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 Station station1;
		 station1 = new Station();
		 station1.passengers = new LinkedList<>();
		 station1.platform = new LinkedList<>();
		 Escalator escalator1 = new Escalator("Escalator 1", station1);
		 Escalator escalator2 = new Escalator("Escalator 2", station1);
		 Escalator escalator3 = new Escalator("Escalator 3", station1);
		 Thread threadOne;
		 threadOne = new Thread(new Runnable() {
		 public void run() {
		 while (true) {
		 synchronized (station1.passengers) {
		 for (int i = 0; i < 50; i++) {
		 Passengers passengers = new Passengers("Passenger");
		 station1.passengers.add(passengers);
		 }
		 station1.passengers.notifyAll();
		 }
		 try {
		 Thread.sleep(250);
		 } catch (InterruptedException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 }
		
		 }
		 });
		
		 Thread threadTwo;
		 threadTwo = new Thread(escalator1);
		
		 Thread threadThree;
		 threadThree = new Thread(escalator2);
		
		 Thread threadFour;
		 threadFour = new Thread(escalator3);
		
		 threadOne.start();
		 threadTwo.start();
		 threadThree.start();
		 threadFour.start();
		 System.out.println();
		
		LinkedList<Wagon> wagon = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			wagon.add(new Wagon(Math.random() * 100 < 30));
		}
		Train train1 = new Train();

		while (!wagon.isEmpty()) {
			Wagon wagon1 = wagon.poll();

		}

		Comparator<Machinists> comparator = new Comparator<Machinists>() {

			@Override
			public int compare(Machinists o1, Machinists o2) {
				// TODO Auto-generated method stub
				if (o1.experience > o2.experience) {
					return -1;
				}
				if (o1.experience < o2.experience) {
					return 1;
				}
				return 0;
			}
		};

		BlockingQueue<Machinists> intQueue = new PriorityBlockingQueue<>(5, comparator);
		Machinists machinist1 = new Machinists(3, "Mikhalych");
		Machinists machinist2 = new Machinists(43, "Yegorych");
		Machinists machinist3 = new Machinists(12, "Anatolievich");
		Machinists machinist4 = new Machinists(23, "Sergeevich");
		Machinists machinist5 = new Machinists(54, "Alkogolievich");
		// intQueue.add(machinist1);
		// intQueue.add(machinist2);
		// intQueue.add(machinist3);
		// intQueue.add(machinist4);
		// intQueue.add(machinist5);
		try {
			intQueue.put(machinist1);
			intQueue.put(machinist2);
			intQueue.put(machinist3);
			intQueue.put(machinist4);
			intQueue.put(machinist5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		LinkedList<Train> train = new LinkedList<>();
		for (int i = 0; i < 20; i++) {
			train.add(new Train());

		}
		Iterator<Train> itr1 = train.iterator();
		LinkedList <Thread> threads = new LinkedList<>();
		while (itr1.hasNext()) {
			train1 = itr1.next();
			Machinists driver1 = intQueue.take();
			driver1.train = train1;
			
			Thread threadFive;
			
			threadFive = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub

					if (driver1 != null) {

						try {

							driver1.gainExperience();
							Thread.sleep((long) (5500 * Math.random() + 1));
							intQueue.put(driver1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

//						System.out
//								.println(Thread.currentThread().getName() + " Driver " + driver1.driverName + " train "
//										+ driver1.train + " and gained " + driver1.experience + " experience points");
					}
				}

			});
			threads.add(threadFive);
			threadFive.start();

		}
		
		for (Thread  i : threads){
			i.join();
		}
		
//		System.out.println(intQueue);
	}
	
	

}
