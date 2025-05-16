package com.mycompany.project_draft1;

//Extends Medicine and implements Scheduled (i.e., controlled/scheduled substance).

public class Morphine extends Medicine implements Scheduled {

	public Morphine(String ID) {
		super(30, ID, "Morphine", 21, 10, "Oral Tablets", "Every 2 Days");
	}

}
