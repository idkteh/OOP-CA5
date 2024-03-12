package main.DAOs;
import java.util.List;
import main.Exceptions.DaoException;
import main.DTOs.CarClass;

import java.util.List;

public interface CarDaoInterface {
    public List<CarClass> findAllCars() throws DaoException;
    public void deleteCarById(int id) throws DaoException;
    public int  insertCar(CarClass car) throws DaoException;
}
