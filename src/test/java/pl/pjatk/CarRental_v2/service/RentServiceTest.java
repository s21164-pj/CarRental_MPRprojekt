package pl.pjatk.CarRental_v2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.CarRental_v2.model.Car;
import pl.pjatk.CarRental_v2.model.Customer;
import pl.pjatk.CarRental_v2.model.Rent;
import pl.pjatk.CarRental_v2.repository.RentRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RentServiceTest {


    @Mock
    private CarService carService;
    @Mock
    private  CustomerService customerService;
    @Mock
    private RentRepository rentRepository;
    @InjectMocks
    private RentService rentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        //Given
        when(rentRepository.findAll()).thenReturn(List.of(new Rent()));
        //When
        List<Rent> all = rentService.findAll();
        //Then
        assertThat(all).hasSize(1);
    }

    @Test
    void shouldHave200AfterRent(){
        //given
        Car car = new Car("Ford", "Panda", "red", 2000, 200);
        Customer customer = new Customer("Daniel", 600);
        //when
        rentService.rentCar(customer, car, 2);
        //then
        assertThat(customer.getWallet()).isEqualTo(200);

    }

    @Test
    void shouldNotBeAvailable(){
        //given
        Car car = new Car("Ford", "Panda", "red", 2000, 200, true);
        Customer customer = new Customer("Daniel", 600);
        //when
        Rent rent = rentService.rentCar(customer, car, 2);
        List<Rent> all = rentService.findAll();
        //then
        assertThat(car.isAvailable()).isEqualTo(false);
    }






}
