package cn.com.smartdevices.bracelet.shoes.c;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class h {
    private h() {
    }

    public static long a() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return instance.getTimeInMillis();
    }

    public static Date a(String str) {
        return new SimpleDateFormat("yyyy-MM").parse(str, new ParsePosition(0));
    }

    public static long b(String str) {
        return new SimpleDateFormat("yyyy-MM-DD").parse(str, new ParsePosition(0)).getTime();
    }

    public static long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(str + " 00:00:00").getTime();
        } catch (Exception e) {
            return -1;
        }
    }
}
