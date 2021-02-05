package pl.pjatk.CarRental_v2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.CarRental_v2.model.Car;
import pl.pjatk.CarRental_v2.repository.CarRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        //Given
        when(carRepository.findAll()).thenReturn(List.of(new Car()));
        //When
        List<Car> all = carService.findAll();
        //Then
        assertThat(all).hasSize(1);
    }

    @Test
    void findById() {
        //Given
        when(carRepository.findById(1L)).thenReturn(Optional.of(new Car("VW", "golf 3", "blue", 1995, 100)));
        //When
        Optional<Car> car = carService.findByID(1L);
        //Then
        assertThat(car).isNotNull();
    }

}
