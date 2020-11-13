package org.example.models;

public class Food implements Cloneable {
    private String description;
    private int quantity;

    public Food(String description, int quantity) {
        this.description = description;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Object clone() {
        try {
            return (Food) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            return null;
        }
    }
}
