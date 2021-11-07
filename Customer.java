

public class Customer  {

	private String name;
	private int  targetTipPct;

	public Customer(String name, int targetTipPct) {
		/* TODO: Add your code here */
		
		this.name = name;
		
		this.targetTipPct = targetTipPct;
		
		
	}

	public String getName() {
		return name;
	}

	public int getTargetTipPct() {
		return targetTipPct;
	}

	public String getDescriptiveMessage(FoodPlace foodPlace) {
		
		return this.name + " dined in " + foodPlace.getName();
	}

	public void dineAndPayCheck(FoodPlace foodPlace, double menuPrice ) {
		/* TODO: Add your code here */
		
		//construct a new check object
		
		Check currentCheck = new Check(menuPrice);
		
		
		double avgTip = (this.targetTipPct + (foodPlace).getTipPercentage())/2;
										//this will refer to the getTipPercentage method of whichever foodplace
										//is being referred to
		
		
		currentCheck.setTipByPct(avgTip);
			
		foodPlace.distributeIncomeAndSalesTax(currentCheck);
			
			
			}
	
		}
