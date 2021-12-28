package com.project.realEstate.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
    @OneToOne
    private Picture picture;
    private String description;
    private int room;
    private int wc;
    private int parking;

    private LocalDateTime created;
    @ManyToOne
    private Seller seller;

    public Property() {
    }

    public Property(String title, int price, Picture picture, String description, int room, int wc, int parking, LocalDateTime created, Seller seller) {
        this.title = title;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.room = room;
        this.wc = wc;
        this.parking = parking;
        this.created = created;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getWc() {
        return wc;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", picture=" + picture +
                ", description='" + description + '\'' +
                ", room=" + room +
                ", wc=" + wc +
                ", parking=" + parking +
                ", created=" + created +
                ", seller=" + seller +
                '}';
    }
}
