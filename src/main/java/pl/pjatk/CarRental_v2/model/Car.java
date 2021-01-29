package pl.pjatk.CarRental_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String model;
    private String color;
    private int productionYear;
    private int pricePerDay;
    private boolean isAvailable;

    @ManyToOne
    @JsonIgnore
    private Customer owner;

}
