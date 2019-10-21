package oop.baitap2;

public class Cat extends Pet {
    private String name;
    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void howToSpeak() {
        System.out.println("Meo meo!!!");
    }

}
