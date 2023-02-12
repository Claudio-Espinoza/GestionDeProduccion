package ufro.dci.gestionapp.model.production.enumerations;

public enum BreadEnum {
    WHITE("Write"), CROISSANT("Croissant") ,SALT("Salt") , NO("No");

    private final String name;

    BreadEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
