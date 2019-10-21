package oop.baitap2;

public class Pet implements ISpeaking {
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
    public void howToSpeak() {
    }

    public String toString() {
        return "This is pet with name: "+this.name;
    }

}
