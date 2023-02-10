package ufro.dci.gestionapp.model.production.enumerations;

public enum DrinkEnum {
    SMALL("Small"), MEDIUM("Medium") ,LARGE("Large");

    private final String size;

    DrinkEnum(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

}
