package com.mycompany.project_draft1;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;

/**
 * JavaFX App
 */
public class App extends Application {
private final Map<String, Integer> selectionCounts = new LinkedHashMap<>();
    private final TextArea historyArea = new TextArea();
    private ComboBox<String> productComboBox = new ComboBox<>();
    
    // Product databases with category prefixes
    private final ObservableList<Item> medicines = FXCollections.observableArrayList( );
    new Stock();
		List<Item> productList = Stock.getProductList();
    for (Item item : productList){
    System.out.println("");}
            
//        "Medicines > Paracetamol", 
//        "Medicines > Ibuprofen", 
//        "Medicines > Amoxicillin",
//        "Medicines > Loratadine", 
//        "Medicines > Omeprazole"
   
    
    private final ObservableList<String> skincare = FXCollections.observableArrayList(
        "Skincare > Moisturizing Cream", 
        "Skincare > Sunscreen SPF 50", 
        "Skincare > Acne Treatment",
        "Skincare > Anti-Aging Serum", 
        "Skincare > Eye Cream"
    );
    
    private final ObservableList<String> shampoos = FXCollections.observableArrayList(
        "Shampoos > Anti-Dandruff", 
        "Shampoos > Volume Boost", 
        "Shampoos > Color Protect",
        "Shampoos > Dry Scalp", 
        "Shampoos > Organic Baby"
    );

    public static void main(String[] args) {
       // intializing stock
		new Stock();
		List<Item> productList = Stock.getProductList();

		// Print sorted product list using describe() methods according to ID
		System.out.println("============== PHARMACY STOCK ITEMS ===============");
		System.out.println("           ===========================");
		System.out.println("");

		// === Sort & Print Medicines ===
		List<Medicine> medicines = new ArrayList<>();
		for (Item item : productList) {
			if (item instanceof Medicine) {
				medicines.add((Medicine) item);
			}
		}
		Collections.sort(medicines);  // Uses Medicine's compareTo()
		System.out.println("============== SORTED MEDICINES (BY ID) ==============");
		for (Medicine med : medicines) {
			med.describe();
		}
		System.out.println(" ");
		// === Sort & Print PersonalCare ===
		List<PersonalCare> personalCareItems = new ArrayList<>();
		for (Item item : productList) {
			if (item instanceof PersonalCare) {
				personalCareItems.add((PersonalCare) item);
			}
		}
		Collections.sort(personalCareItems);  // Uses PersonalCare's compareTo()
		System.out.println("=========== SORTED PERSONAL CARE (BY ID) ===========");
		for (PersonalCare pc : personalCareItems) {
			pc.describe();
		}
		
		
		
		// try - catch block for ordering and printing recipt
		try {
			System.out.println("Processing Order");

			// Create order array - note the exact product names must match (case-insensitive)
			Order[] order1 = {
				new Order("Morphine", 10),
				new Order("Steroids", 6),
				new Order("Panadol", 6),
				new Order("Tylenol", 6),
				new Order("VitalBoost", 6),
				new Order("EnergyPlus", 6),
				new Order("SilkSmooth", 6),
				new Order("Clear", 6),
				new Order("GlowGuard", 6),
				new Order("ClearTone", 6)
			};

			// Process receipt
			Receipt receipt1 = new Receipt(order1);
			receipt1.printReceipt();

		} catch (Exceptions.ItemNotFoundException e) {
			System.err.println("Order Failed - " + e.getMessage());
			// You could add recovery logic here, like suggesting similar products
		} catch (Exceptions.InsufficientStockException e) {
			System.err.println("Order Failed - " + e.getMessage());
			// Could suggest partial fulfillment or backorder
		} catch (IllegalArgumentException e) {
			System.err.println("Order Failed - " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Order Failed - " + "unexpected behaviour");
			e.printStackTrace();
		}

		
		
		/// Print product list using describe() methods
		System.out.println("============== PHARMACY STOCK ITEMS ===============");
		System.out.println("           ===========================");
		System.out.println("");

		// === Sort & Print Medicines ===
		for (Item item : productList) {
			if (item instanceof Medicine) {
				medicines.add((Medicine) item);
			}
		}
		
		Collections.sort(medicines);  // Uses Medicine's compareTo()
		System.out.println("============== SORTED MEDICINES (BY ID) ==============");
		for (Medicine med : medicines) {
			med.describe();
		}
		System.out.println(" ");
		
		// === Sort & Print PersonalCare ===
		for (Item item : productList) {
			if (item instanceof PersonalCare) {
				personalCareItems.add((PersonalCare) item);
			}
		}
		
		Collections.sort(personalCareItems);  // Uses PersonalCare's compareTo()
		System.out.println("=========== SORTED PERSONAL CARE (BY ID) ===========");
		for (PersonalCare pc : personalCareItems) {
			pc.describe();
		}

		
		// taking order #2
		try {
			System.out.println("Processing Order");

			// Create order array - note the exact product names must match (case-insensitive)
			Order[] order2 = {
				new Order("panadol", 2),
				new Order("clear", 1)
			};

			Receipt receipt2 = new Receipt(order2);
			receipt2.printReceipt();

		} catch (Exceptions.ItemNotFoundException e) {
			System.err.println("Order Failed - " + e.getMessage());
			// You could add recovery logic here, like suggesting similar products
		} catch (Exceptions.InsufficientStockException e) {
			System.err.println("Order Failed - " + e.getMessage());
			// Could suggest partial fulfillment or backorder
		} catch (IllegalArgumentException e) {
			System.err.println("Order Failed - " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Order Failed - " + "unexpected behaviour");
			e.printStackTrace();
		}
		/*
		 * // Morphine Morphine morphine = new Morphine("12");
		 * 
		 * // Steroids Steroids steroids = new Steroids("13");
		 * 
		 * // Paracetamol Paracetamol panadol = new Paracetamol(12.75, "P001",
		 * "Panadol", 6, 100, "Oral", "Take 1 tablet every 6 hours", 20); Paracetamol
		 * tylenol = new Paracetamol(9.50, "P002", "Tylenol", 10, 80, "Oral",
		 * "Take 2 tablets after meals", 16);
		 * 
		 * // Multivitamins Multivitamins vitalBoost = new Multivitamins(29.99, "MV001",
		 * "VitalBoost", 18, 50, "Unisex", "Ginseng"); Multivitamins energyPlus = new
		 * Multivitamins(34.50, "MV002", "EnergyPlus", 12, 30, "Male", "Coenzyme Q10");
		 * 
		 * // Shampoo Shampoo silkSmooth = new Shampoo(15.99, "S001", "SilkSmooth", 5,
		 * 60, "Female", "Lavender"); Shampoo clear = new Shampoo(13.49, "S002",
		 * "Clear", 8, 40, "Male", "Mint");
		 * 
		 * // Skincare Skincare glowGuard = new Skincare(22.00, "SC001", "GlowGuard",
		 * 16, 35, "Female", "sun protection"); Skincare clearTone = new Skincare(18.75,
		 * "SC002", "ClearTone", 14, 50, "Unisex", "cleansing");
		 * 
		 */

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create radio buttons for category selection
        ToggleGroup categoryGroup = new ToggleGroup();
        
        RadioButton medicineRadio = new RadioButton("Medicines");
        medicineRadio.setToggleGroup(categoryGroup);
        medicineRadio.setSelected(true);
        medicineRadio.setUserData(medicines);
        
        RadioButton skincareRadio = new RadioButton("Skincare");
        skincareRadio.setToggleGroup(categoryGroup);
        skincareRadio.setUserData(skincare);
        
        RadioButton shampooRadio = new RadioButton("Shampoos");
        shampooRadio.setToggleGroup(categoryGroup);
        shampooRadio.setUserData(shampoos);
        
        // Set up the product dropdown with category prefix
        productComboBox.setPromptText("Select a category first");
        productComboBox.setPrefWidth(300);
        //productComboBox.setItems(medicines); // Default to medicines
        
        // Handle category changes
        categoryGroup.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                ObservableList<String> products = (ObservableList<String>) newVal.getUserData();
                productComboBox.setItems(products);
                productComboBox.setPromptText("Select " + ((RadioButton)newVal).getText());
            }
        });
        
        // Handle product selection
        productComboBox.setOnAction(event -> {
            String selectedWithCategory = productComboBox.getValue();
            if (selectedWithCategory != null) {
                // Extract pure product name (remove category prefix)
                String selected = selectedWithCategory.split(" > ")[1];
                
                // Update count
                selectionCounts.merge(selected, 1, Integer::sum);
                updateHistoryDisplay();
                
                // Reset selection
                productComboBox.getSelectionModel().clearSelection();
                productComboBox.setValue(null);
            }
        });
        
        // Configure history display
        historyArea.setPrefSize(350, 200);
        historyArea.setEditable(false);
        historyArea.setWrapText(true);
        historyArea.setStyle("-fx-font-family: monospace;");
        
        // Create layout
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
            new Label("Select Product Category:"),
            new VBox(5, medicineRadio, skincareRadio, shampooRadio),
            new Separator(),
            new Label("Available Products:"),
            productComboBox,
            new Separator(),
            new Label("Selection History:"),
            historyArea
        );
        
        // Set up scene
        Scene scene = new Scene(root, 450, 550);
        primaryStage.setTitle("Pharmacy Category Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void updateHistoryDisplay() {
        StringBuilder historyText = new StringBuilder();
        selectionCounts.forEach((name, count) -> {
            historyText.append(String.format("%2dx %s%n", count, name));
        });
        historyArea.setText(historyText.toString());
        historyArea.setScrollTop(Double.MAX_VALUE);
    }
}
