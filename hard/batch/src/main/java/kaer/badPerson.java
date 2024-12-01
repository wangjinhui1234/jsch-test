package kaer;

public class badPerson extends Person{
    public int size ;


    public badPerson(String name){

    }

    @Override
    public void method() {
        super.method();
    }


}
class Test001{
    public static void main(String[] args) {
        badPerson badPerson = new badPerson("hhahaha");

    }
}