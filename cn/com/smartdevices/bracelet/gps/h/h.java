package cn.com.smartdevices.bracelet.gps.h;

import android.text.TextUtils;
import android.util.Base64;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.C0596r;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class h {
    private h() {
    }

    public static double a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    public static float a(float f, int i) {
        return new BigDecimal((double) f).setScale(i, 4).floatValue();
    }

    public static long a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j <= 0 ? System.currentTimeMillis() : j * 1000);
        instance.add(2, 1);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return (instance.getTimeInMillis() / 1000) - 1;
    }

    public static long a(long j, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j <= 0 ? System.currentTimeMillis() : j * 1000);
        if (i > 0) {
            instance.add(2, i + 1);
        } else if (i < 0) {
            instance.add(2, i - 1);
        } else {
            instance.add(2, 1);
        }
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return (instance.getTimeInMillis() / 1000) - 1;
    }

    public static String a(ArrayList<Byte> arrayList) {
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = ((Byte) arrayList.get(i)).byteValue();
        }
        return Base64.encodeToString(bArr, 2);
    }

    public static Date a(String str) {
        return new SimpleDateFormat("yyyy-MM").parse(str, new ParsePosition(0));
    }

    public static List<String> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM");
        try {
            Date parse = simpleDateFormat.parse(str);
            long time = simpleDateFormat.parse(str2).getTime();
            Calendar instance = Calendar.getInstance();
            List<String> arrayList = new ArrayList();
            for (long time2 = parse.getTime(); time2 < time; time2 = instance.getTimeInMillis()) {
                arrayList.add(simpleDateFormat2.format(parse));
                instance.setTimeInMillis(time2);
                instance.add(2, 1);
            }
            return arrayList;
        } catch (ParseException e) {
            C0596r.a(C0410c.c, e.getMessage());
            return null;
        }
    }

    public static long b(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j <= 0 ? System.currentTimeMillis() : j * 1000);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return instance.getTimeInMillis() / 1000;
    }

    public static long b(long j, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j <= 0 ? System.currentTimeMillis() : j * 1000);
        if (i != 0) {
            instance.add(2, i);
        }
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return instance.getTimeInMillis() / 1000;
    }

    public static long b(String str) {
        return new SimpleDateFormat("yyyy-MM").parse(str, new ParsePosition(0)).getTime();
    }

    public static String b(double d, int i) {
        return String.format("%." + i + "f", new Object[]{Double.valueOf(a(d, i))});
    }

    public static String b(float f, int i) {
        return String.format("%." + i + "f", new Object[]{Float.valueOf(a(f, i))});
    }

    public static String c(long j) {
        if (j > 0) {
            return new SimpleDateFormat("yyyy-MM").format(new Date(1000 * j));
        }
        throw new IllegalArgumentException();
    }
}
