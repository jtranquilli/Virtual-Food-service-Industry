
import java.util.List;
import java.util.LinkedList;

public class FoodStand extends FoodPlace {

    public FoodStand(String name, double fixedCosts, WorkingOwner owner) {
        /* TODO: Add your code here */
        /* TODO: Also edit the super call */
    	
        super(name,fixedCosts,owner);
       
    }

    @Override
    public String toString() {
        return "Name of FoodStand: " + this.getName() +
                "\n" + "Owner: " + this.getOwner();
    }

    @Override
    public void workShift(int hours) {
        // no salaried workers so do nothing
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
        /* TODO: Add your code here */
        /* TODO: Also remove return statement below*/
    	
    	List<IncomeTaxPayer> list2 = new LinkedList();
    	
    	list2.add(getOwner());
    	
        return list2;

    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
        /* TODO: Add your code here */
    	
    	double totalTip = check.getTip();
    	
    	double mPrice = check.getMenuPrice();
    	
    	double woInc = this.getOwner().getIncome();
    	
    	this.getOwner().setIncome(woInc + mPrice + totalTip);
    	
    	this.setTotalSalesTax(check.getSalesTax());
    	
    	
    	
    	
    }

    @Override
    public double getTipPercentage() {
        /* TODO: Add your code here */
        /* TODO: Also remove return statement below*/
    	
    	WorkingOwner h = (WorkingOwner) this.getOwner();
    	
    	double val = h.getTargetTipPct();
    	
        return val;
    }
}
