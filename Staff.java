
public class Staff extends IncomeTaxPayer {

	private int salaryPerHour;
	final private int incomeTaxPercentage = 25;

	public Staff(String name, boolean isCook) {
		/* TODO: Add your code here */
		
		/* TODO: Also edit the super call */
		super(name);
		
		if (isCook == true) {
			
			this.salaryPerHour = 20;
		}
		
		else {
		
			this.salaryPerHour = 10;
		
		}
	}

	public int getSalaryPerHour() {
		return salaryPerHour;
	}

	public int getIncomeTaxPercentage() {
		return incomeTaxPercentage;
	}

	public double workHours(int numHours) {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		
		double earned = numHours * this.salaryPerHour; // refers to this workers salary
		
		double total = getIncome() + earned; // does this.getIncome() refer to the correct thing???
		
		this.setIncome(total);  
		
		return earned;
	}

	@Override
	public double calculateIncomeTax() {
		/* TODO: Add your code here */
		/* TODO: Also remove return statement below*/
		
		double tax = 0.25 * this.getIncome(); 
		
		return tax;
	}

}
