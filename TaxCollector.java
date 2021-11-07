
import java.util.ArrayList;
import java.util.List;

public class TaxCollector {

	private List<FoodPlace> foodPlaces = new ArrayList<>();

	private double incomeTaxCollected;
	private double salesTaxCollected;

	public TaxCollector(List<FoodPlace> foodPlaces) {
		/* TODO: Add your code here */
		
		this.foodPlaces = foodPlaces;
		
	}

	public List<FoodPlace> getFoodPlaces() {
		
		return foodPlaces;
	}

	public double getIncomeTaxCollected() {
		return incomeTaxCollected;
	}

	public double getSalesTaxCollected() {
		return salesTaxCollected;
	}

	public void collectTax() {
		/* TODO: Add your code here */
		
		//for each foodplace sales tax is collected and added to salesTaxCollected
		
		for (int i = 0; i < foodPlaces.size(); i++) {
			
			double tt =(foodPlaces.get(i)).getTotalSalesTax();
			
			salesTaxCollected += tt;
		}
		
		//for each IncomeTaxPayer their tax is collected and added to TaxCollected
		
		for (int i = 0; i < foodPlaces.size(); i++) {
			//fastfood
			if ( foodPlaces.get(i) instanceof FastFood) {
				
				double a = foodPlaces.get(i).getOwner().calculateIncomeTax();
				
				for (int j = 0; j < ((FastFood) foodPlaces.get(i)).getStaff().size(); j++) {
					
					double b = ((FastFood) foodPlaces.get(i)).getStaff().get(j).calculateIncomeTax();
					
					incomeTaxCollected += b;
				}
				
				incomeTaxCollected +=a	;
			}
			
			//restaurant
			if ( foodPlaces.get(i) instanceof Restaurant) {
				double x = foodPlaces.get(i).getOwner().calculateIncomeTax();
				
				for (int j = 0; j < ((Restaurant) foodPlaces.get(i)).getIncomeTaxPayers().size(); j++) {
					
					double y = ((Restaurant) foodPlaces.get(i)).getIncomeTaxPayers().get(j).calculateIncomeTax();
					
					incomeTaxCollected += y;
				}
				
				incomeTaxCollected += x;
			}
			
			//foodstand
			if ( foodPlaces.get(i) instanceof FoodStand) {
				
				double h = foodPlaces.get(i).getIncomeTaxPayers().get(0).calculateIncomeTax();
			
				incomeTaxCollected += h;
		}
		}
	}
	
	public String toString() {
		return "TaxCollector: income tax collected: " + incomeTaxCollected + ", sales tax collected: " + salesTaxCollected;
	}
	
}
