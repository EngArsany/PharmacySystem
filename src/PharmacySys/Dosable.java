package PharmacySys;

//This interface indicates medicines that hava a dose
public interface Dosable {

    String getDosageInstructions(); // e.g., "Take 2 tablets daily"

    String getAdministrationRoute(); // e.g., "Oral", "Topical", "Injection" boolean

}
