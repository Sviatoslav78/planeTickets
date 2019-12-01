package com.model;

public enum Plane {
    NOT_DEFINED(0, "null"),
    AIRBUS(700, "Airbus"),
    Boeing(230, "Boeing"),
    ANTONOV(80, "Antonov"),
    TUPOLEV(166, "Tupolev");

    private int sitsNumber;
    private String name;

    Plane(int sitsNumber, String name) {
        this.sitsNumber = sitsNumber;
        this.name = name;
    }

    public int getSitsNumber() {
        return sitsNumber;
    }

    public String getName() {
        return name;
    }
}
