
import java.util.List;
import java.util.LinkedList;

public class Restaurant extends FoodPlace {

	private Staff cook;
	private Server server;

	public Restaurant(String name, double fixedCosts, Owner owner, Staff cook, Server server) {
		/* TODO: Add your code here */
		/* TODO: Also edit the super call */
		// add staff + server
		
		super(name,fixedCosts,owner);
		
		this.server = server;
		
		this.cook = cook;
	}

	public Staff getCook() {
		return cook;
	}

	public Server getServer() {
		return server;
	}

	@Override
	public String toString() {
		return "Name of restaurant: " + this.getName() +
				"\n" + "Owner: " + this.getOwner() +
				"\n" + "Cook: " + cook +
				"\n" + "Server: " + server;
	}

	@Override
	public void workShift(int hours) {
		/* TODO: Add your code here */
		
		// add income to cook, server, owner
		
		double cookhours = this.cook.workHours(hours);
		
		double serverhours = this.server.workHours(hours);
		
		//double cookPay = 20 * hours;
		
		//double serverPay = 10 * hours;
		
		double t = cookhours + serverhours;
		
		Owner o = this.getOwner();
		
		double g = o.getSalaryExpenses();
		
		o.setSalaryExpenses(t + g);
	}

	@Override
	public List<IncomeTaxPayer> getIncomeTaxPayers() {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		
		List<IncomeTaxPayer> list1 = new LinkedList();
		
		Owner o = getOwner();
		
		list1.add(o);
		
		list1.add(cook);
		
		list1.add(server);
		
		
		return list1;
	}

	@Override
	public void distributeIncomeAndSalesTax(Check check) {
		/* TODO: Add your code here */
		//give owner the menu price
		//give cook 20% of tip and server 80% of tip
		
		//the tip component of the check should already be properly set
		//as the average of the two target tips
		//this is done in the dineAndPayCheck() 
		
		Owner o = getOwner();
		
		double ownerincome = check.getMenuPrice();
		
		double d = o.getIncome();
		
		o.setIncome(ownerincome + d);

		double totalTip = check.getTip();
		
		double serverinc = server.getIncome();
		
		server.setIncome(serverinc + 0.8*(totalTip));
		
		double cookinc = cook.getIncome();
		
		cook.setIncome(cookinc + 0.2*(totalTip));
													// below accumulates salestax
		double salestx = check.getMenuPrice() * 0.15;
		
		double currtax = this.getTotalSalesTax();
		
		this.setTotalSalesTax(salestx + currtax);
		
	}

	@Override
	public double getTipPercentage() {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		
		// returns the servers target tip percentage
		
		double val = this.server.getTargetTipPct();
		return val;
	}

}
