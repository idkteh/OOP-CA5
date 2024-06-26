package main.java.org.example.Current.BusinessObjects;

import main.java.org.example.Current.DTOs.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Author: Logan Rushe
 */
public class ClientServerCommands {
    public String DisplayCarById = "display car by id";
    public String DisplayAllCars = "display all cars";
    public String AddACar = "add a car";
    public String DeleteCarById = "delete car by id";
    public String GetImagesList = "get images list";
    public List<String> imagesList = new ArrayList<>();
    public String GetImage = "get image";
    public ClientServerCommands() {
        imagesList.add("parrot_image.jpg");
        imagesList.add("Cool_Background.jpg");
        imagesList.add("Metroid_Dread.jpg");
    }
}
