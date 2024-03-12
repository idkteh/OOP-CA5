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
}

