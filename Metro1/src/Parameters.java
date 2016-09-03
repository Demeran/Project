import java.util.LinkedList;
import java.util.List;

public class Parameters {
int Favnumqt;
static final int min = 0;
static final int max = 1000;

public int getFavnumqt() {
	return Favnumqt;
}
public void setFavnumqt(int favnumqt) {
	if (Favnumqt >= min & Favnumqt <= max)
	Favnumqt = favnumqt;
}
public int getTariftimecount() {
	return Tariftimecount;
}
public void setTariftimecount(int tariftimecount) {
	if (Tariftimecount >= min & Tariftimecount <= max)
	Tariftimecount = tariftimecount;
}
public Parameters() {
	super();
}
public Parameters(int favnumqt, int tariftimecount, int activation_price) {
	super();
	
	Favnumqt = favnumqt;
	Tariftimecount = tariftimecount;
	Activation_price = activation_price;
}
public int getActivation_price() {
	return Activation_price;
}
public void setActivation_price(int activation_price) {
	if (Activation_price >= min & Activation_price <= max)
	Activation_price = activation_price;
}
int Tariftimecount;
int Activation_price;

}
