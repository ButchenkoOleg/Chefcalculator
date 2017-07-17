package com.example.oleg.chefcalculator;


class Products {
    private String name;
    private int weight;
    private double coast;
    private int weightSpanding;

    private double expenditure;

    public double getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(double expenditure) {
        this.expenditure = expenditure;
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

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public int getWeightSpanding() {
        return weightSpanding;
    }

    public void setWeightSpanding(int weightSpanding) {
        this.weightSpanding = weightSpanding;
    }

    public Products(String name, int weight, double coast, int weightSpanding) {
        this.name = name;
        this.weight = weight;
        this.coast = coast;
        this.weightSpanding = weightSpanding;
        // Calculate expenditure & rounding 2 number after the dot
        this.expenditure = Math.floor(coast/weight* this.weightSpanding *100)/100;
    }




}
