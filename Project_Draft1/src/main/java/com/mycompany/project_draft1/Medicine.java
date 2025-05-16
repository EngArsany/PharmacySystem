package com.mycompany.project_draft1;

public abstract class Medicine extends Item implements Dosable{

	private String dosageInstructions;
	private String adminstrationRoute;

	public Medicine(double price, String ID, String name, int minimumAge, int stock, String adminstrationRoute,
			String dosageInstructions) {
		super(price, ID, name, minimumAge, stock);
		this.adminstrationRoute = adminstrationRoute;
		this.dosageInstructions = dosageInstructions;

	}

	// Getters for the medicine's properties
	@Override //overrides dosable interface
	public String getDosageInstructions() {
		// Dosable Interface method
		return dosageInstructions;
	}

	@Override //overrides dosable interface
	public String getAdministrationRoute() {
		// Dosable Interface method
		return adminstrationRoute;
	}

	@Override // From Item Class
	public void describe() {
		super.describe();
		System.out.println("Dosage Instructions: " + this.getDosageInstructions());
		System.out.println("Administration Route: " + this.getAdministrationRoute());
	}
        public String getItemsInfo(){
        
        return super.getItemsInfo() +" Instructions: " +this.getDosageInstructions();
        }
}
