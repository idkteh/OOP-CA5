package main.DTOs;

public class CarClass {
    private int id;
    private String model;
    private String brand;
    private String colour;
    private int production_year;
    private int price;

    public CarClass(int id, String model, String brand, String colour, int production_year, int price){
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.colour = colour;
        this.production_year = production_year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getProduction_year() {
        return production_year;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "main.DAOs.CarClass{" +
                "id - " + id +
                ", model - " + model +
                ", brand - " + brand +
                ", colour - " + colour +
                ", production_year - " + production_year +
                ", price - " + price +
                '}';
    }
}
