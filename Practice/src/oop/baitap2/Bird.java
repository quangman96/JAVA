package oop.baitap2;

public class Bird implements ISpeaking{
    String name;
    public Bird(){
    }

    public Bird(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void speak() {
        System.out.println("Chim chim");
    }
}
