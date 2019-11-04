package oop.baitap2;

public class Cat extends Pet {
//    private String name;
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("Meo meo!!!");
    }

}
