package main.java.org.example.Current.DAOs;

import main.java.org.example.Current.DTOs.Car;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public interface CarDaoInterface {
    List<Car> findAllCars() throws SQLException;
    void deleteCarById(int id) throws SQLException;

    /**
     * Main Author: Logan Rushe
     * <p>
     * Insert a given Car into the car table
     * @param car The car object to be inserted
     * @return The inserted Car if successful, or the Car will be NULL if it's already contained within the table
     * @throws SQLException if any SQL statements fail
     */
    Car  insertCar(Car car) throws SQLException;
    Car findCarById(int id) throws SQLException;

    /**
     * Main Author: Logan Rushe
     * <p>
     * Returns a sorted list of Cars from the database
     * @param carComparator The comparator used to sort the list
     * @return The sorted Car List
     * @throws SQLException if any SQL statements fail
     */
    List<Car> findCarsUsingFilter(Comparator<Car> carComparator) throws SQLException;
    void updateCar(int id, Car car) throws SQLException;
}
