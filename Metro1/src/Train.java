import java.util.LinkedList;

public class Train {
LinkedList<Wagon> wagoncoll;
	public Train() {
	super();
	this.wagoncoll = new LinkedList<>();
}
	@Override
	public String toString() {
		return "Train ["+hashCode()+"]";
	}
public void wagonAdd(Wagon wagon){
	
	while (wagoncoll.size()<5){
		wagoncoll.add(wagon);
			if (wagoncoll.getFirst().isHeader){
				wagoncoll.addFirst(wagon);
					if (wagoncoll.getFirst().isHeader){
						wagoncoll.addLast(wagon);
						if (wagoncoll.getFirst().isHeader & wagoncoll.getLast().isHeader){
							wagoncoll.add(1, wagon);
						}
					}
			}
		
	}
	
}

}
