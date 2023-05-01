package com.gradusinterview.stockmarket.model;

import jakarta.persistence.*;

@Entity
@Table(name="stocks")
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String ticket;

    private double currentPrice;

    private String sector;

    public Stock() {
    }

    public Stock(Long id, String name, String ticket, double currentPrice, String sector) {
        this.id = id;
        this.name = name;
        this.ticket = ticket;
        this.currentPrice = currentPrice;
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
