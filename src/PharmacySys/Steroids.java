package PharmacySys;

// Steroids class represents a scheduled medicine item
public class Steroids extends Medicine implements Scheduled {

	public Steroids(String ID) {
		super(100, ID, "Steroids", 21, 15, "Oral.", "Take 1 tablet daily.");

	}

}
