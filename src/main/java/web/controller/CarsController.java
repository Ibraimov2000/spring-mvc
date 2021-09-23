package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CarsController {
    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int allCars, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Rav4","gray", 2020));
        cars.add(new Car("Camry", "white", 2015));
        cars.add(new Car("Corolla", "black", 2010));
        cars.add(new Car("AMG", "blue", 2012));
        cars.add(new Car("Brabus", "black", 2014));
        cars = CarService.cars(cars, allCars);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
