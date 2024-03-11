package main.DAOs;
import java.util.List;
import main.Exceptions.DaoException;
import main.DTOs.CarClass;

import java.util.List;

public interface CarDaoInterface {
    public List<CarClass> findAllUsers() throws DaoException;


}
