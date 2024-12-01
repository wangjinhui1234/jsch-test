package kaer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Optional;

public class personTest {

    public static void main(String[] args) {
        Hashtable<Object, Object> table = new Hashtable<>();

        Person person = new Person();

        if (Objects.nonNull(person)){
            System.out.println("对象为空");
        }
        if(person == null){
            System.out.println("字段属性为空");
        }
        Date date = person.getDate();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM HH:mm:ss:SSS");


        StringBuilder sb = new StringBuilder();
        sb.append("你好你好 \n");
        sb.append(",hahahah");
        System.out.println(sb.toString());

    }
}
