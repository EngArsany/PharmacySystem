package com.mycompany.project_draft1;

public class Paracetamol extends Medicine {

	private int unitAmount; // 500 mg, 1000 mg

	public Paracetamol(double price, String ID, String name, int minimumAge, int stock, String adminstrationRoute,
			String dosageInstructions, int unitAmount) {
		super(price, ID, name, minimumAge, stock, adminstrationRoute, dosageInstructions);
		this.unitAmount = unitAmount;

	}

	public int getUnitAmount() {
		return unitAmount;
	}

	@Override
	public void describe() {
		// TODO Auto-generated method stub
		super.describe();
		System.out.println("Unit amount: " + unitAmount);
	}
        public String getItemsInfo(){
        
        return super.getItemsInfo() +" Unit amount in mg: "+ this.getUnitAmount();
        }

}
