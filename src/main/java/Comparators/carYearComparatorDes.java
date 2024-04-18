package main.java.Comparators;

import main.java.DTOs.Car;

import java.util.Comparator;

public class carYearComparatorDes implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        int a = Integer.compare(c1.getProduction_year(), c2.getProduction_year());
        if (a == -1) return 1;
        else if (a == 1) return -1;
        else return 0;
    }
}
// **** Part of logan's code
