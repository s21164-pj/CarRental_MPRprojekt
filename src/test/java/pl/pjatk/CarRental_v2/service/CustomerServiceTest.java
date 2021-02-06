package pl.pjatk.CarRental_v2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.CarRental_v2.model.Customer;
import pl.pjatk.CarRental_v2.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        //Given
        when(customerRepository.findAll()).thenReturn(List.of(new Customer()));
        //When
        List<Customer> all = customerService.findAll();
        //Then
        assertThat(all).hasSize(1);
    }

    @Test
    void findById() {
        //Given
        when(customerRepository.findById(1L)).thenReturn(Optional.of(new Customer()));
        //When
        Optional<Customer> customer = customerService.findByID(1L);
        //Then
        assertThat(customer).isNotNull();
    }

    @Test
    void shouldDeposit() {
        //Given
        Customer customer = new Customer("Mietek", 100);
        //When
        customerService.depositMoney(customer, 100);
        //Then
        assertThat(customer.getWallet()).isEqualTo(200);
    }


}
