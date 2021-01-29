package pl.pjatk.CarRental_v2.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startingDate = LocalDate.now();
    private LocalDate endDate;
    private int price;
    private String comment;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Car car;
}
