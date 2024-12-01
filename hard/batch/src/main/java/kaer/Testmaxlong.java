package kaer;

import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Testmaxlong {
    public static void main(String[] args) {
      //  System.arraycopy();
        Person person = new Person();
        System.out.println(person.getAge());
        HashMap<String, Long> map = new HashMap<>();
        for (Map.Entry<String , Long> entry:map.entrySet()) {
            String key = entry.getKey();
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(arrayList)){
            System.out.println("集合测试");
        }
        int size1 = arrayList.size();
       // map.get("0")
        String str ="dddmx-ppmd";
        str.length();
        int length = args.length;
        int size = arrayList.size();

        for (int i = 0, j = 10 ;i <= j;) {
            System.out.println("nihao");
        }

        char[] chars = str.toCharArray();
        //chars.length

        int index = str.indexOf('-');
        String substring = str.substring(index + 1);
        System.out.println(substring);

        List<Integer> list = Arrays.asList(8, 6, 5, 4, 3, null, 100, 82, 29);

        list.stream().sorted(Comparator.nullsFirst(Comparator.naturalOrder())).forEach(n -> System.out.print(n + "\t"));
        StringJoiner stringJoiner = new StringJoiner(",");
        //字符串转时间
        String dateTimeStr = "2019-11-01 11:11:11";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, df);

        String dateTimeStr2 = "2019-12-01 18:11:12";
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime2 = LocalDateTime.parse(dateTimeStr, df);
        long between = ChronoUnit.MILLIS.between(dateTime2, dateTime);



    }

    public static LocalDateTime dateToLocalDateTime(Date date){
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }

    public void method(){
        //

    }
}
