package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String production;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String production) {
        super(id, name, price);
        this.production = production;
    }

    public String getProducter() {
        return production;
    }

    public void setProducter(String production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(production, that.production);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), production);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "production='" + production + '\'' +
                '}';
    }
}