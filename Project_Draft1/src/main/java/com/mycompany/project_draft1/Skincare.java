package com.mycompany.project_draft1;

public class Skincare extends PersonalCare {

	private String routine; // e.g., cleansing, moisturizing, sun protection

	public Skincare(double price, String ID, String name, int minimumAge, int stock, String gender, String routine) {
		super(price, ID, name, minimumAge, stock, gender);
		this.routine = routine;
	}

	public String getRoutine() {
		return routine; // Return the skincare routine
	}

	@Override
	public void describe() {
		super.describe();
		System.out.println("Routine: " + routine);
	}
        public String getItemsInfo(){
        return super.getItemsInfo() +" Routine " +this.getRoutine();
        }

}
