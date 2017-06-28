package com.example.oleg.chefcalculator;


class Products {
    public Products(String name, int weight, int coast) {
        this.name = name;
        this.weight = weight;
        this.coast = coast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
       this.weight = weight;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    private String name;
    private int weight;
    private int coast;
    private int spanding;






}
