package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getCars(int count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mercedes-Benz", "S600", 300000));
        cars.add(new Car("BMW", "750", 100000));
        cars.add(new Car("VAZ", "2109", 500));
        cars.add(new Car("Tesla", "3", 130000));
        cars.add(new Car("Audi", "S7", 150000));
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
