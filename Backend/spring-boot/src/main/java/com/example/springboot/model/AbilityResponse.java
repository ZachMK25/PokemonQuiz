package com.example.springboot.model;

public class AbilityResponse {
    private final String name;
    private final String description;
    public AbilityResponse(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
