package pl.pjatk.CarRental_v2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int wallet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> ownedCars = new ArrayList<>();

}
