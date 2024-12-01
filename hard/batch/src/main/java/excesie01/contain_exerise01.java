package excesie01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class contain_exerise01 {
    public static void main(String[] args) {
        String[] arr = {"qq","qqhhhh","qddfq","dfdfaqq","dddd","da","lbslbs"};
        List<String> strings = Arrays.asList("qq", "qqhhhh", "qddfq", "dfdfaqq", "dddd", "da", "lbslbs");
        List<String> stringList = strings.stream().filter(a -> a.contains("qq")).collect(Collectors.toList());
        for (String str: stringList) {
            System.out.println(str);
        }
    }
}
