package erchashu;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String path = "C:/Users/Think/Desktop/test";
        File file = new File(path);

        List<String> asList = Arrays.asList("/home/ap/dkbs/1.txt", "/home/ap/dkbs/2.txt");
        for (String str:asList) {
            String substring = str.substring(str.lastIndexOf("/"));
            asList.add(substring);
        }


        String str1 = "s*tand_poll%";
        String replace1 = str1.replace("*", "%");
        System.out.println(replace1);
        String replace = str1.replace("%", "_");
        System.out.println(replace);
        File parentFile = file.getParentFile();
        System.out.println(parentFile);
        Stream<Path> list = Files.list(Paths.get(path));
        String s = "dfsdf%sfdsd%s";
        String format = String.format(s, "job_step_id", "dddd");
        System.out.println("formate--->" + format);
        List<String> stringList = list.map(Path::toString).filter(f -> !new File(f).getName().startsWith(".")).sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        for (String str:stringList) {
            System.out.println(str);
        } {
            System.out.println("true" + "1");
        }

        if (path.equals("C:/Users/Think/Desktop/test/hh/test")){
            System.out.println("true" + "2");
        }

    }
}
