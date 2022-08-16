package Chuong2_Basic;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StringSwitchStatement {
    public static String getTypeOfDay(Calendar calendar){
        String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK,
                                              Calendar.SHORT,
                                              new Locale("vi"));
        return switch (type) {
            case "Th 2" -> "Start of work week";
            case "Th 3" -> "Thứ 3 ngày trong tuần";
            case "Th 4" -> "Thứ 4 ngày trong tuần";
            case "Th 5" -> "Midweek";
            case "Th 6" -> "End of work week";
            case "Th 7" -> "Thứ 7 ngày trong tuần";
            case "CN" -> "Weekend";
            default -> "Unknown";
        };
    }

    public static void main(String[] args) {
        example2();
    }

    private static void example2() {
        StringSwitchStatement statement = new StringSwitchStatement();
        Calendar calendar = Calendar.getInstance();
        System.out.println("Today is " + statement.getTypeOfDay(calendar));
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE) + 1);
        System.out.println("Tomorow is " + getTypeOfDay(calendar));
    }


}
