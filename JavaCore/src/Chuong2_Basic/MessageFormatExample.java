package Chuong2_Basic;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageFormatExample {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("EEEEE, dd MMMMM yyyy");
        String message = MessageFormat.format("Hello {0}! Today is {1}","Hòa","Th 3",
                                              dateFormat.format(Calendar.getInstance().getTime()));
        System.out.println(message);
    }

}
