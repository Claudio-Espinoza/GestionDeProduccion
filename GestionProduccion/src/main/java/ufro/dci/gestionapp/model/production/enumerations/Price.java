package ufro.dci.gestionapp.model.production.enumerations;

public enum Price {
    PRICE_0(0), PRICE_1(1000), PRICE_2(1500) ,PRICE_3(2000),PRICE_4(2500) , PRICE_5(7000);

    private final int price;

    Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
