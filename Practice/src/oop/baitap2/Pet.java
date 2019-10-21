package oop.baitap2;

public abstract class Pet implements ISpeaking {
    private String name;

    public Pet (){
    }

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void speak() {
    }

    public String toString() {
        return "This pet with name is: "+this.name;
    }

}
