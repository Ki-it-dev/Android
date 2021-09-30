package com.example.lehuunhatkhoa_b13_custom1;

public class Phone {
    private String namePhone;
    private int imagePhone,pricePhone;

    public Phone(String namePhone, int imagePhone, int pricePhone) {
        this.namePhone = namePhone;
        this.imagePhone = imagePhone;
        this.pricePhone = pricePhone;
    }

    public int getPricePhone() {
        return pricePhone;
    }

    public void setPricePhone(int pricePhone) {
        this.pricePhone = pricePhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public int getImagePhone() {
        return imagePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public void setImagePhone(int imagePhone) {
        this.imagePhone = imagePhone;
    }
}
