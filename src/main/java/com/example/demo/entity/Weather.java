package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherSeq;

    @Column(length = 20, nullable = false)
    private String weatherNo;

    @Column(length = 500, nullable = false)
    private String day;

    @Column(length = 500, nullable = false)
    private String dow;

    @Column(length = 500, nullable = false)
    private String imageM;

    @Column(length = 500, nullable = false)
    private String imageA;

    @Column(length = 500, nullable = false)
    private String tempAm;

    @Column(length = 500, nullable = false)
    private String tempPm;

    @Column(length = 2000, nullable = false)
    private String address;

    @Builder
    public Weather(String weatherNo, String day, String dow, String imageM, String imageA, String tempAm, String tempPm, String address) {
        this.weatherNo = weatherNo;
        this.day = day;
        this.dow = dow;
        this.imageM = imageM;
        this.imageA = imageA;
        this.tempAm = tempAm;
        this.tempPm = tempPm;
        this.address = address;
    }
}