package ru.bellintegrator.practice.countries.views;

public class CountryView {

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CountryView{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
