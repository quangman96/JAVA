package oop.aood.interface1;
import java.util.Comparator;
import oop.kethua.Circle;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if(c1.getRadius()> c2.getRadius()) return 1;
        else if(c1.getRadius()<c2.getRadius()) return -1;
        else return 0;
    }
}
