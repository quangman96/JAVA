package oop.baitap.denpin;

public class Lamp {
    private String name;
    private boolean On = false;

    public Lamp() {
    }

    public Lamp(String name, boolean On) {
        this.name = name;
        this.On = On;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return On;
    }

    public void setOn(boolean on) {
        On = on;
    }

    public void turnOn(Battery battery){
        if(!On){
            On = true;
            System.out.println(this.name +" turn on");
            System.out.println("battery has : " + battery.getEnergy()+" energy");
        }
        else {
            System.out.println(this.name + " is on");
        }
    }

    public void turnOff(Battery battery){
        if(On){
            On = false;
            System.out.println(this.name +" turned off");
            System.out.println("battery has : " + battery.getEnergy()+" energy");
        }
        else {
            System.out.println(this.name + " is off");
        }
    }
}
