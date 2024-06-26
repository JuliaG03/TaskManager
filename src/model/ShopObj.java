package model;

import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

public class ShopObj {

    private String name;
    private String description;
    private int quantity;
    private double pricePerUnit;
    private double finalPrice;

    //void read function +print


    public ShopObj(){}

    public ShopObj(String name, String description, int quantity, double pricePerUnit, double finalPrice) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.finalPrice = finalPrice;
    }



    public void read(Scanner in) throws ParseException{
        System.out.println("Enter name: ");
        this.name = in.nextLine();
        System.out.println("Enter description: ");
        this.description = in.nextLine();
        System.out.println("Enter quantity: ");
        this.quantity = in.nextInt();
        System.out.println("Enter price per unit: ");
        this.pricePerUnit = in.nextDouble();
        System.out.println("Enter final price: ");
        this.finalPrice = in.nextDouble();
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per unit: " + pricePerUnit);
        System.out.println("Final price: " + finalPrice);
    }

    @Override
    public String toString() {
        return "model.ShopObj{" +
                "name='" + name + '\'' +
                ",\n description='" + description + '\'' +
                ",\n quantity=" + quantity +
                ",\n pricePerUnit=" + pricePerUnit +
                ",\n finalPrice=" + finalPrice +
                '}';
    }

    public void calculatePrice(){
        finalPrice = pricePerUnit*quantity;
    }
    public void increaseQuantity(int amount) {
        quantity += amount;
        calculatePrice();
    }

    public void decreaseQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            System.out.println("Insufficient quantity to decrease.");
        }
        calculatePrice();
    }


    public void update(ShopObj shopObj) throws ParseException {
        System.out.println("Initial values: ");
        shopObj.print();
        System.out.println("Give the new values: ");
        Scanner in = new Scanner(System.in);
        shopObj.read(in);

    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopObj shopObj)) return false;
        return getQuantity() == shopObj.getQuantity() && Double.compare(getFinalPrice(), shopObj.getFinalPrice()) == 0 && Objects.equals(getName(), shopObj.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getQuantity(), getPricePerUnit(), getFinalPrice());
    }
}
