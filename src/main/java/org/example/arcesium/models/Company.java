package org.example.arcesium.models;

public class Company {
    private String name;
    private String basename;

    public Company(){}

    public Company(String name, String basename) {
        this.name = name;
        this.basename = basename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", basename='" + basename + '\'' +
                '}';
    }
}
