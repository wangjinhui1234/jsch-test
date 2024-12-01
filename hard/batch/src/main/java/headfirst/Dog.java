package headfirst;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Dog extends Canine{
    public String name;
    public int size;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        Object dog = new Dog();

        Horse horse = new Horse();
        System.out.println(horse.getClass());
        System.out.println(horse.toString());
        Horse horse1 = new Horse();
        System.out.println(horse1.hashCode());
        System.out.println(horse.hashCode());
        Dog dog1 = new Dog(

        );
        dog1.bark();
        dog1.size = 60;

        Dog[] dogs = new Dog[3];
        dog1.name ="Fred";
        dogs[0]=dog1;
       dogs[1]= new Dog("Marge");
        dogs[2]=new Dog("Bart");
        int x= 0;
        while (x <dogs.length){
            dogs[x].bark();
            x++;
        }
        System.out.println("last dog's name is" + dogs[2].name);
    }
    public void bark(){
        if (size > 10) {
            System.out.println(name + "says Ruff!");
        }else {
            System.out.println(name + "汪汪汪");
        }
    }
    public void eat(){

    }
    public void chaseCat(){}
}
