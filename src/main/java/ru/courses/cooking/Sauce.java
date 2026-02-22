package ru.courses.cooking;

public class Sauce {
    private String sauceName;
    private SpicyLevels spicyLevel;

    public Sauce(String sauceName, SpicyLevels spicyLevel) {
        this.sauceName = sauceName;
        this.spicyLevel = spicyLevel;
    }

    @Override
    public String toString() {
        return "Соус "  +
                 sauceName + ":" +
                spicyLevel;
    }
}
