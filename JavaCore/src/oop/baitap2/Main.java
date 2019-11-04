package oop.baitap2;

public class Main {
    public static void main(String[] args) {

        Pet[] pets = new Pet[3];
        pets[0] = new Dog("milu",new License());
        pets[1] = new Cat("Meow");
        pets[2] = new Retriever("Cho dien",new License(false));

        for (Pet x:pets) {
            System.out.println(x);
            x.speak();
            if(x instanceof ILicensable){
                System.out.println(((ILicensable) x).getLicense().toString());
            }
        }

        Bird chim = new Bird("chim");

//        Dog milu = new Dog("Milu",new License(true,10,20));
//        System.out.println( milu.getLicense().toString());;
//        Dog[] dogs = new Dog[2];
//        dogs[0] = new Dog("Scubidu",new License(true,10,30));
        Retriever tai = new Retriever("taichodien",new License(false));
        tai.retrieve(chim);
//
//        dogs[0].getLicense();
//        dogs[1].getLicense();
        }

}
