package com.example.tp2_traductor;

public class Palabra {
    private String espanol, ingles;
    private int img;

    public Palabra(String espanol, String ingles, int img) {
        this.espanol = espanol;
        this.ingles = ingles;
        this.img = img;
    }

    public String getEspanol() {
        return espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public int getImg() {
        return img;
    }
}
