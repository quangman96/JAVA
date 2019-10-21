package oop.baitap1.adameva;

public class Human {
    private String name;
    private double weight;

    public Human() {
    }

    public Human(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void eat(Apple apple) {
        this.weight++;
        apple.decreaseApple();
        System.out.println(this.getName()+" have weight: "+this.getWeight());
        System.out.println("Apple have: "+ apple.getWeight());
    }
}
