import java.util.LinkedList;
import java.util.List;

public class tarif {
	int payroll;
	public List<call_prices> callprices;
	public List<Parameters> parameters;
	public tarif(int payroll, List<call_prices> callprices, List<Parameters> parameters, int sms_price) {
		super();
		this.payroll = payroll;
		this.callprices = callprices;
		this.parameters = parameters;
		this.sms_price = sms_price;
	}

	public tarif() {
		super();
		this.parameters = new LinkedList<>();
		this.callprices = new LinkedList<>();
	}

	static final int min = 0;
	static final int max = 1000;

	public int getPayroll() {
		return payroll;
	}

	public void setPayroll(int payroll) {
		if (payroll >= min & payroll <= max)
		this.payroll = payroll;
	}

	public int getSms_price() {
		return sms_price;
	}

	public void setSms_price(int sms_price) {
		if (sms_price >= min & sms_price <= max)
		this.sms_price = sms_price;
	}

	int sms_price;
}
