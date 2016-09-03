import java.util.Random;

public class Machinists {
int experience;
String driverName;
Train train;

public Machinists(int experience, String driverName) {
	super();
	this.experience = experience;
	this.driverName = driverName;
}
public Machinists(int experience) {
	super();
	this.experience = experience;
}
public void gainExperience(){
	Random rnd = new Random();
	experience = experience + rnd.nextInt(50);
}
@Override
public String toString() {
	return "Machinists [experience=" + experience + ", driverName=" + driverName + "]";
}
}
