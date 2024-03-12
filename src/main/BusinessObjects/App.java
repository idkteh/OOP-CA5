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
            int code = IUserDao.insertCar(new CarClass(1, "Civic", "Honda", "Silver", 2010, 25000));
            if(code == 1) {
                System.out.println("\nCar added successfully");
            } else if (code == 0) {
                System.out.println("\nCar already exists in table");
                }
            System.out.println("\nCall deleteById() where id = 14");
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
    Feature 4 - Logan - done
 */














