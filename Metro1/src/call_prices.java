
public class call_prices {
int inside_network_price;
static final int min = 0;
static final int max = 1000;

public int getInside_network_price() {
	return inside_network_price;
}
public void setInside_network_price(int inside_network_price) {
	if (inside_network_price >= min & inside_network_price <= max)
	this.inside_network_price = inside_network_price;
}
public int getOutside_network_price() {
	return outside_network_price;
}
public void setOutside_network_price(int outside_network_price) {
	if (outside_network_price >= min & outside_network_price <= max)
	this.outside_network_price = outside_network_price;
}
public int getStational_phone_calls() {
	return stational_phone_calls;
}
public void setStational_phone_calls(int stational_phone_calls) {
	if (stational_phone_calls >= min & stational_phone_calls <= max)
	this.stational_phone_calls = stational_phone_calls;
}
int outside_network_price;
int stational_phone_calls;

}
