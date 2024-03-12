package main.BusinessObjects;
import main.DAOs.CarDaoInterface;
import main.DAOs.MySqlCarDao;
import main.DAOs.MySqlDao;
import main.DTOs.CarClass;
import main.Exceptions.DaoException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CarDaoInterface IUserDao = new MySqlCarDao();

        try {
            System.out.println("\nCall findAllUser()");
            List<CarClass> cars = IUserDao.findAllCars();

            if (cars.isEmpty()) {
                System.out.println("There are no cars");
            } else {
                for (CarClass car : cars) {
                    System.out.println(car.toString());
                }
            }
            System.out.println("\nCall deleteById()");
            IUserDao.deleteCarById(14);

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}


/* TODO ask dermot to help with the output cause why is there '
    Features 1 - Dominik - done
    Feature 2 - Dominik
    Feature 3 - Ida - done
    Feature 4 - Logan
 */














