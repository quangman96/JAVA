package oop.baitap2;

public class Dog extends Pet implements ILicensable{
    private License license;
    public Dog() {
    }

    public Dog(String name,License license) {
        super(name);
        this.license = license;
    }


    @Override
    public void speak() {
        System.out.println("Gau gau!!!");
    }

    @Override
    public License getLicense() {
        return license;
    }
}
