package pl.pjatk.CarRental_v2.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.CarRental_v2.model.Car;
import pl.pjatk.CarRental_v2.model.Customer;
import pl.pjatk.CarRental_v2.model.Rent;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RentServiceTestIT {

    @Autowired
    private RentService rentService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CarService carService;

    @AfterEach
    void cleanup() {
        rentService.deleteAll();
    }


    @Test
    void shouldAddRent() {
        //given
        Car car = new Car("Ford", "Panda", "red", 2000, 200, true);
        Customer customer = new Customer("Daniel", 600);
        //when
        Rent rent = rentService.rentCar(customer, car, 2);
        List<Rent> all = rentService.findAll();
        //then
        assertThat(all).hasSize(1);
    }

    @Test
    void shouldFinishRent() {
        //given
        Car car = carService.addCar(new Car("Ford", "Panda", "red", 2000, 200, true));
        Customer customer = customerService.addCustomer(new Customer("Daniel", 600));
        //when
        Rent rent = rentService.rentCar(customer, car, 2);
        rentService.newReturn(rent, "", 0, 0);
        //then
        assertThat(rent.getEndDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void shouldNotHaveEndDate() {
        //given
        Car car = new Car("Ford", "Panda", "red", 2000, 200);
        Customer customer = new Customer("Daniel", 600);
        //when
        Rent rent = rentService.rentCar(customer, car, 2);
        //then
        assertThat(rent.getEndDate()).isNull();

    }

    @Test
    void shouldHaveStartDate() {
        //given
        Car car = new Car("Ford", "Panda", "red", 2000, 200);
        Customer customer = new Customer("Daniel", 600);
        //when
        Rent rent = rentService.rentCar(customer, car, 2);
        //then
        assertThat(rent.getStartingDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void shouldHaveEndDateAfterRent() {
        //given
        Rent rent = rentService.rentCar(new Customer(), new Car(), 2);
        Car car = new Car("Ford", "Panda", "red", 2000, 200);
        Customer customer = new Customer("Daniel", 600);
        //when
        Rent after = rentService.newReturn(rent, "", 0, 0);
        //then
        assertThat(after.getEndDate()).isEqualTo(LocalDate.now());
    }


}
