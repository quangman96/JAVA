package oop.aood.animal;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "O o O";
    }

    @Override
    public String howToEat() {
        return "bup bup";
    }
}
