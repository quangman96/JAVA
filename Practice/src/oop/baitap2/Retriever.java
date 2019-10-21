package oop.baitap2;

public class Retriever extends Dog {
    private License license;

    public Retriever() {
    }

    public Retriever(String name, License license) {
        super(name,license);
    }

    @Override
    public void speak() {
        System.out.println("Goam goam!!");
    }

    public void retrieve(Bird bird){
        System.out.println(this.getName()+" an thit "+ bird.getName());
    }
}
