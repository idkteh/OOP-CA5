package main.DAOs;
import main.DTOs.CarClass;
import main.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlCarDao extends MySqlDao implements CarDaoInterface{
    @Override
    public List<CarClass> findAllCars() throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CarClass> carsList = new ArrayList<>();
        try
        {
            //Get connection object using the getConnection() method inherited
            // from the super class (MySqlDao.java)
            connection = this.getConnection();

            String query = "SELECT * FROM car";
            preparedStatement = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int id = resultSet.getInt("ID");
                String model = resultSet.getString("MODEL");
                String brand = resultSet.getString("BRAND");
                String colour = resultSet.getString("COLOUR");
                int production_year = resultSet.getInt("PRODUCTION_YEAR");
                int price = resultSet.getInt("PRICE");


                CarClass u = new CarClass(id,model,brand,colour,production_year,price);
                carsList.add(u);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllCarResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllCars() " + e.getMessage());
            }
        }
        return carsList;     // may be empty
    }
    public void deleteCarById(int id) throws DaoException{

        //CarDaoInterface carDaoInterface = new MySqlCarDao();

        Connection connection = null;
        PreparedStatement preparedStatement1 = null;

        try
        {
            String query1 = "DELETE FROM car_rental.car WHERE id = ?";
            connection = this.getConnection();
            preparedStatement1 = connection.prepareStatement(query1);
            System.out.println("Building a PreparedStatement to delete a new row in database.");

            preparedStatement1.setInt(1, id);
            preparedStatement1.executeUpdate();

            System.out.println("Disconnected from database");

        } catch (SQLException e) {
            throw new DaoException("deleteCarById() " + e.getMessage());
        }
        finally
        {
            try
            {
                if (preparedStatement1 != null)
                {
                    preparedStatement1.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("deleteCarById() " + e.getMessage());
            }
        }
    }
    public int insertCar(CarClass car) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement checkStatement = null;
        ResultSet resultSet = null;
        int code;

        try {
            connection = this.getConnection();

            // Prepare insert statement
            String query = "INSERT INTO car VALUES (null, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getColour());
            preparedStatement.setInt(4, car.getProduction_year());
            preparedStatement.setInt(5, car.getPrice());

            // Prepare statement to check if the car is in the table already
            String checkQuery = "SELECT * FROM car WHERE model = ? AND brand = ?";
            checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, car.getModel());
            checkStatement.setString(2, car.getBrand());
            resultSet = checkStatement.executeQuery();

            // If the car is found in the table
            if(resultSet.next())
                code = 0;
            else
                code = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("insertCar() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (checkStatement != null)
                {
                    checkStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("insertCar() " + e.getMessage());
            }
        }
        return code;
    }
    //    Feature 2 – Find and Display (a single) Entity by Key
//    e.g. getPlayerById(id ) – return a single entity (DTO) and display its contents.

    //    **** Dominik's code ****
    public CarClass findCarById(int id) throws DaoException{
//        Declaring needed variables, setting them to null for now
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CarClass car = null;
        //            Everything in the try block will try to execute code inside, if not
        try {
// setting connection variable to the function that connects to our database
            connection = this.getConnection();
//            Storing our sql query into a string variable, ? gets defined below
            String query = "SELECT * FROM car WHERE id = ?";
//  Prepares the statement to be sent into the database
            preparedStatement = connection.prepareStatement(query);
//            in our query setting the ? to be a int of a value of id that's passed into the function
            preparedStatement.setInt(1, id);
// finally our sql statement gets executed by calling executeQuery();
            resultSet = preparedStatement.executeQuery();
//            if there is data in the resultSet do this
            if(resultSet.next()){
//  retrieves the data from database and stores them into our variables
                int carId = resultSet.getInt("ID");
                String model = resultSet.getString("MODEL");
                String brand = resultSet.getString("BRAND");
                String colour = resultSet.getString("COLOUR");
                int production_year = resultSet.getInt("PRODUCTION_YEAR");
                int price = resultSet.getInt("PRICE");
// then create a new object of a type CarClass and put our values into it, if it is found
                car = new CarClass(carId, model, brand, colour, production_year, price);
            }
//            catch if our try block does not run
        } catch (SQLException e){
            throw new DaoException("findCarById()" + e.getMessage());
//      after all this we need to make sure to close the connection
        } finally {
            try {
                if (resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
//                call our function from mysqldao that will close the system
                if(connection != null){
                    freeConnection(connection);
                }
//                if anything goes wrong throw exception
            } catch (SQLException e){
                throw new DaoException("findCarById()" + e.getMessage());
            }
        }
//        at the end return our car object if it was found
        return car;
    }
}

