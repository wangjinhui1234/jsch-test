package excesie01;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class execise_01 {
    public static void main(String[] args) {

        String str ="dd1234";
        boolean dd = str.contains("dd");
        System.out.println(dd);
        //str.indexOf()
        str.contains(str);
        long star= System.currentTimeMillis();
        //System.out.println(star / 1000 );
        long end = System.currentTimeMillis() + (2 * 60 * 1000 * 60 * 60 + 1 * 60 * 60 *1000);
        long diff = end - star;
        long  hour =  diff /  (60 *60 * 60 * 1000);
        long   min= (diff / ( 60 * 60 * 1000)) - (diff /  (60 *60 * 1000));
        long  second = diff % 1000;

        System.out.println(  "hour---"+ hour +  ", min"  + min + "----second:" + second);
        //h  fen miao haomiao
    }
}
