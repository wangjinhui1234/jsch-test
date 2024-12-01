package kaer;

import java.util.Date;

public class Person {

    public  String Name;
    public int age;
    public Date date;

    public Person() {
    }

    public Person(String name, int age, Date date) {
        Name = name;
        this.age = age;
        this.date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void method(){
        System.out.println("我是父类");
    }
}
