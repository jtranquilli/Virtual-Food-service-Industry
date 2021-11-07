
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class FastFood extends FoodPlace {

    private List<Staff> staff = new ArrayList<>();

    public FastFood(String name, double fixedCosts, Owner owner, List<Staff> staff) {
        /* TODO: Add your code here */
        /* TODO: Also edit the super call */
    	
        super(name,fixedCosts,owner);
        
                
        for ( int i = 0; i < staff.size(); i++) {
        	
        	this.staff.add(staff.get(i));
        }   
    }

    public List<Staff> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name of FastFood: " + this.getName() +
                "\n" + "Owner: " + this.getOwner());
        int index = 1;
        for (Staff staff: staff) {
            builder.append("\n" + "Staff " + index++ + " : " + staff );
        }
        return builder.toString();
    }

    @Override
    public void workShift(int hours) {
        /* TODO: Add your code here */
    	
    	for (int i = 0; i < (this.staff).size(); i++) {
    		
    		//check  if they are cook or server;
    		
    		((Staff) staff.get(i)).workHours(hours);
    		
    		double pph = ((Staff) staff.get(i)).getSalaryPerHour();
    		
    		double currinc = this.getOwner().getSalaryExpenses();
    		
    		this.getOwner().setSalaryExpenses(currinc + (pph * hours));
    		
    			
    		}
    	
    	
    		
    	}
    

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        /* TODO: Add your code here */
        /* TODO: Also remove return statement below*/
    	
    	List<IncomeTaxPayer> list3 = new LinkedList();
    	
    	list3.add(getOwner()); // adds owner to the list
    	
    	for (int i = 0; i < this.staff.size(); i++) {
    		
    	IncomeTaxPayer r = (IncomeTaxPayer) staff.get(i);
    	
    		list3.add(r); //adds the rest of fastfood staff to the list
    		
    		
    		
    	}
    	
    	
        return list3;
    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
        /* TODO: Add your code here */
    	// tip is split evenly among staff other than owner
    	//total sales tax must be set
    	
    	Owner o = getOwner();
		
		double ownerincome = check.getMenuPrice();
		
		double d = o.getIncome();
		
		o.setIncome(ownerincome + d);
		
		int numOfStaff = this.staff.size();
		
		double totalTip = check.getTip();
		
		double divTip = totalTip / numOfStaff;
		
		for (int i = 0 ; i < staff.size(); i++) {  //add divided tips to each staffs income
			
			double staffInc = ((Staff) staff.get(i)).getIncome();
			
			((Staff) staff.get(i)).setIncome(staffInc + divTip);
		}
		double salestx = check.getMenuPrice() * 0.15;
		
		double currtax = this.getTotalSalesTax();
		
		this.setTotalSalesTax(salestx + currtax);
		
		
    }

    @Override
    public double getTipPercentage() {
        return 0;
    }
}
