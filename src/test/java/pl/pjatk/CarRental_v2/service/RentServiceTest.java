package pl.pjatk.CarRental_v2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.CarRental_v2.model.Car;
import pl.pjatk.CarRental_v2.model.Rent;
import pl.pjatk.CarRental_v2.repository.RentRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RentServiceTest {

    @Mock
    private RentRepository rentRepository;
    private CarService carService;
    private  CustomerService customerService;
    @InjectMocks
    private RentService rentService;

    @Test
    void findAll() {
        //Given
        when(rentRepository.findAll()).thenReturn(List.of(new Rent()));
        //When
        List<Rent> all = rentService.findAll();
        //Then
        assertThat(all).hasSize(1);
    }


}
