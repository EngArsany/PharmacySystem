package com.mycompany.project_draft1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * JavaFX App
 */
public class App extends Application {

    private final TextArea cartTextField = new TextArea();
    private ComboBox<String> productComboBox = new ComboBox<>();

    // Product databases with category prefixes
    private final ObservableList<String> medicines = FXCollections.observableArrayList();

    private final ObservableList<String> personalCare = FXCollections.observableArrayList();

    public static void main(String[] args) {
        // intializing stock
        // intializing stock
        new Stock();
        //Encapsulation: all data and methods related to the stock is in the Stock class

        //Program Header
        System.out.println("============== PHARMACY STOCK Program ===============");
        System.out.println("           ===========================");
        System.out.println("");

        //== Order #1 ==
        // try - catch block for ordering and printing recipt
        try {
            System.out.println("=============== PROCESSING ORDER 1 ===============");

            // Create order array
            ArrayList<Order> order1 = new ArrayList<>(List.of(
                    new Order("Morphine", 10),
                    new Order("steroids", 6),
                    new Order("Panadol", 10),
                    new Order("Tylenol", 6),
                    new Order("VitalBoost", 6),
                    new Order("EnergyPlus", 6),
                    new Order("SilkSmooth", 6),
                    new Order("Clear", 6),
                    new Order("GlowGuard", 6),
                    new Order("ClearTone", 6)));

            // Process receipt
            Receipt receipt1 = new Receipt(order1);
            receipt1.printReceipt();
        } catch (Exceptions.ItemNotFoundException | Exceptions.InsufficientStockException | IllegalArgumentException e) {
            //Use multicatch to reduce redundancy
            System.err.println("Order Failed - " + e.getMessage());
        }


        // taking order #2
        try {
            System.out.println("=============== PROCESSING ORDER 2 ===============");

            // Create order array - note the exact product names must match (case-insensitive)
            ArrayList<Order> order2 = new ArrayList<>();
            order2.add(new Order("panadol", 2));
            order2.add(new Order("clear", -1));

            Receipt receipt2 = new Receipt(order2);
            receipt2.printReceipt();
        } catch (Exceptions.ItemNotFoundException | Exceptions.InsufficientStockException | IllegalArgumentException e) {
            System.err.println("Order Failed - " + e.getMessage());
        }

        // Print sorted product list using describe() methods according to ID
        // === Sort & Print All Items in short form ===
        Stock.viewProductList();    //Short list to check sorting
        Stock.describeList();   //Long list to check inheritance and polymorphism
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        new Stock(); //Instantiate Stock to use productList
        List<Item> productList = Stock.getProductList();
        for (Item item : productList) {
            if (item instanceof Medicine) { // Categorizes some productList items into "Medecine" main category 
                if (item instanceof Morphine) {// Further Ctaegorizes the items into more sub-categories
                    medicines.add("Morphine > " + item.getName());
                }
                if (item instanceof Steroids) {
                    medicines.add("Steroids > " + item.getName());
                }
                if (item instanceof Paracetamol) {
                    medicines.add("Paracetamol > " + item.getName());
                }
            }

            if (item instanceof PersonalCare) {// Categorizes some productList items into "Personal Care" main category
                if (item instanceof Skincare) {
                    personalCare.add("Skincare > " + item.getName());
                }
                if (item instanceof Shampoo) {
                    personalCare.add("Shampoo > " + item.getName());
                }
                if (item instanceof Multivitamins) {
                    personalCare.add("Multivitamins > " + item.getName());
                }
            }

        }

        // Create Image placeholder
        Image logo = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5V7nyZWgF00UQFIoRmQ-1dbl8NKKXyPMnSA&s");
        ImageView logoImage = new ImageView(logo);
        logoImage.setFitWidth(120);
        logoImage.setPreserveRatio(true);

        // Create radio buttons for category selection
        ToggleGroup categoryGroup = new ToggleGroup();

        RadioButton medicineRadio = new RadioButton("Medicines");
        medicineRadio.setToggleGroup(categoryGroup);
        medicineRadio.setUserData(medicines);

        RadioButton personalCareRadio = new RadioButton("Personal Care");
        personalCareRadio.setToggleGroup(categoryGroup);
        personalCareRadio.setUserData(personalCare);

        // Set up the product dropdown with category prefix
        productComboBox.setPromptText("Select a category first");
        productComboBox.setPrefWidth(300);
        productComboBox.setVisible(false);

        //Hbox for the image and Radio buttons
        HBox hbox = new HBox(300);
        hbox.getChildren().addAll(new VBox(15, new Label("Select Product Category"), medicineRadio, personalCareRadio), logoImage);

        // Category change listener
        categoryGroup.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            productComboBox.setVisible(true); //Combo box appears when user selects a category from radio button
            if (newVal == medicineRadio) {
                productComboBox.setItems(medicines);
                productComboBox.setPromptText("Select Medicine");
            } else if (newVal == personalCareRadio) {
                productComboBox.setItems(personalCare);
                productComboBox.setPromptText("Select Personal Care item");
            }
            
        });
        ArrayList<Order> cart = new ArrayList<>();
        // Selection handler
        productComboBox.setOnAction(event -> {

            String selectedWithCategory = productComboBox.getValue();
            if (selectedWithCategory != null) {
                String selected = selectedWithCategory.split(" > ")[1];
                try {
                    Item chosen = Stock.findItemByName(selected);
                    productComboBox.setValue(null);
                    try {
                        cart.add(new Order(chosen));
                        cartTextField.appendText(selected + "\n");
                    cartTextField.appendText(chosen.getItemsInfo() + "\n");
                    
                    } catch (Exceptions.InsufficientStockException ex2) {
                        popUpWarning("Not enough Items available", ex2.getMessage());
                    }
                } catch (Exceptions.ItemNotFoundException warn) {}
            }

        });

        Button clearButton = new Button("Clear Selection");
        clearButton.setOnAction(e -> {
            cartTextField.clear();
            for (Order order : cart){
            order.getItem().increaseStock();
            }
                    });
        Button checkoutButton = new Button("Checkout");
        checkoutButton.setOnAction(e -> {
            Receipt bill = new Receipt(cart);
            Stage checkoutStage = new Stage();
            checkoutStage.setTitle("Checkout");
            Label label = new Label("Total Price is: " + bill.getTotalPrice());
            label.setAlignment(Pos.CENTER);
            Scene scene = new Scene(label, 300, 150);
            checkoutStage.setScene(scene);
            checkoutStage.show();
        });
      
        // Configure cart display
        cartTextField.setPrefSize(350, 200);
        cartTextField.setEditable(false);
        cartTextField.setWrapText(true);
        cartTextField.setStyle("-fx-font-family: monospace;");

        // Create layout
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                hbox,
                new Separator(),
                new Label("Available Products"),
                productComboBox,
                new Separator(),
                new Label("Cart"),
                cartTextField,
                clearButton,
                checkoutButton
        );

        // Set up scene
        Scene scene = new Scene(root, 600, 550);
        root.setStyle("-fx-background-color: #50C878;");
        primaryStage.setTitle("Pharmacy Information System");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    
    private void popUpWarning(String header, String content) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
