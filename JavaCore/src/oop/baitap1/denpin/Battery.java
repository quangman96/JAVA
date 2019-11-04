package oop.baitap1.denpin;

public class Battery {
    private int energy;

    public Battery() {
    }

    public Battery(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void decreaseEnergy() {
        if (this.energy > 0 ) {
            this.energy --;
        } else {
            System.out.println("Over power to use!");
        }
    }
}
