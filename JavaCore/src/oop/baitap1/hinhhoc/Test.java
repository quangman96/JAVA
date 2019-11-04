package oop.baitap1.hinhhoc;


    public class Test {
        public static void main(String[] args) {
//            Circle circle = new Circle(5);
//            Rengtangle rectangle = new Rengtangle(5, 10);
//            Square square = new Square(5);

            Shape shape = new Shape(new Square(3),new Rengtangle(3,5),new Circle(2));


            shape.draw();

//            shape.setCircle(6);
//            shape.setRectangle(7,10);
//            shape.setSquare();
//            System.out.println(shape.toString());
//            shape.draw();
        }
}
