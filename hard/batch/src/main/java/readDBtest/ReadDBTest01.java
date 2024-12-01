package readDBtest;

import java.lang.reflect.Field;

public class ReadDBTest01 {
    public static void main(String[] args) {
        Class<MyClass> myClassClass = MyClass.class;
        Field[] declaredFields = myClassClass.getDeclaredFields();
        for (Field  fd:declaredFields
             ) {
            System.out.println(fd);
            System.out.println(fd);
           // fd.setAccessible(true);
            System.out.println(fd.getName()  + "---" + fd);
        }


    }
}
