package designpattern.abstractclass_templatepattern.ex4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar();
        Car ecoCar = new EcoCar();

        List<Car> carList = new ArrayList<>();

        carList.add(sportsCar);
        carList.add(ecoCar);

        carList.forEach(Car::driving);


    }
}
