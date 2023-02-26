package ufro.dci.gestionapp.model.production.enumerations;

public enum Type {
    WHITE("White"), CROISSANT("Croissant") ,SALT("Salt") , NO("No");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
