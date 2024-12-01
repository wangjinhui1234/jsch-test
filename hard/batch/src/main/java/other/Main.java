package other;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Main {
    public static void main(String[] args) {
            String timeStr = "2022-01-08 12:34:56.12";

            // 创建一个 DateTimeFormatterBuilder，以处理不确定位数的毫秒
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm:ss")
                    .appendOptional(new DateTimeFormatterBuilder()
                            .appendFraction(ChronoField.MILLI_OF_SECOND, 0, 3, true)
                            .toFormatter())
                    .toFormatter();

            // 解析字符串为 LocalDateTime 对象
            LocalDateTime dateTime = LocalDateTime.parse(timeStr, formatter);

            // 定义输出字符串的格式（不包含毫秒）
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // 格式化 LocalDateTime 对象为字符串（不包含毫秒）
            String formattedDate = dateTime.format(outputFormatter);

            // 输出结果
            System.out.println(formattedDate);
        }
    }
