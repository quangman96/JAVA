package oop.baitap2;

public class Bird implements ISpeaking{
    public Bird(){
    }
    @Override
    public void howToSpeak() {
        System.out.println("Chim chim");
    }
}
