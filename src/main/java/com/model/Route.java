package com.model;

public enum Route {
    NOT_DEFINED("Choose"),
    KYIV("Kyiv"),
    PARIS("Paris"),
    LONDON("London"),
    BERLIN("Berlin"),
    OSLO("Oslo"),
    RIGA("Riga"),
    BUDAPESHT("Budapesht"),
    BRATISLAVA("Bratislava"),
    MOSCOW("Moscow");

    private String name;

    Route(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
