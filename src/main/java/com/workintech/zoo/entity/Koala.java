package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Koala {
    private int id;
    private String name;
    private double sleepHour; // Test double bekliyor
    private double weight;
    private String gender;
}
