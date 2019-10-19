package oop.baitap.adameva;

public class Apple {
    private int weight;

    public Apple(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void decreaseApple() {
        if(weight>0){
            weight--;
        } else {
            System.out.println("Over apple");
        }
    }
}
