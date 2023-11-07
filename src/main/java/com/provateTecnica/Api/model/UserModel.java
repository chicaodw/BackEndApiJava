package com.provateTecnica.Api.model;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * UserModel
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    private static final AtomicLong counter = new AtomicLong();
    private Long id;

    private String gender;
    private String name;
    private String last_name;
    private String city;
    private String state;
    private String country;
    private String email;
    private String birthday;
    private String cell;
    private String thumbnail;

    public UserModel() {
        this.id = counter.incrementAndGet();
    }

    public UserModel(String name, String last_name, String city, String state, String country, String email) {
        this.name = name;
        this.last_name = last_name;
        this.city = city;
        this.state = state;
        this.country = country;
        this.email = email;
    }

}