package ru.bellintegrator.practice.countries.views;

/**
 * Class to view Country
 */
public class CountryView {

    /**
     * Country name
     */
    private String name;

    /**
     * Country code
     */
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
