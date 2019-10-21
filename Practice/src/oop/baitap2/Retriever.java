package oop.baitap2;

public class Retriever extends Dog {
    private License license;

    public Retriever() {
    }

    public Retriever(String name, License license) {
        super(name,license);
    }

    @Override
    public void howToSpeak() {
        System.out.println("Goam goam!!");
    }

    public Bird retrieve(){
        return null;
    }
}
