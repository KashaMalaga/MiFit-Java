package cn.com.smartdevices.bracelet.f;

import android.content.Context;
import android.text.format.DateFormat;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.t;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import kankan.wheel.widget.a;

public class f {
    public static final int a = 24;
    public static final int b = 60;
    public static final int c = 1440;
    private static final boolean d = false;
    private static final String e = "TimeUtils";

    public static CharSequence a(Context context, int i, int i2) {
        String[] e = e(i);
        t.a(context, 1.33f);
        if (e[0].equals(Constants.VIA_RESULT_SUCCESS)) {
            return context.getString(r.time_format_min, new Object[]{e[1]});
        }
        return context.getString(r.time_format_hour_min, new Object[]{e[0], e[1]});
    }

    public static String a(int i) {
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, i / b);
        gregorianCalendar.set(12, i % b);
        date.setTime(gregorianCalendar.getTimeInMillis());
        return a(date);
    }

    public static String a(Context context, int i) {
        if (e(i)[0].equals(Constants.VIA_RESULT_SUCCESS)) {
            return context.getString(r.time_format_min, new Object[]{e(i)[1]});
        }
        return context.getString(r.time_format_hour_min, new Object[]{e(i)[0], e(i)[1]});
    }

    public static String a(Boolean bool, long j) {
        Context a = BraceletApp.a();
        String str = bool.booleanValue() ? "yyyy-MM-dd " : "MM-dd ";
        return !DateFormat.is24HourFormat(a) ? c(new Date(j)) ? str + a.getString(r.detial_ampm_format) : str + a.getString(r.ampm_format) : str + "HH:mm";
    }

    public static String a(Date date) {
        return b(date);
    }

    public static String b(int i) {
        String[] c = c(i);
        return c[0] + a.ci + c[1];
    }

    public static String b(Context context, int i) {
        String[] d = d(i);
        return context.getString(r.time_format_hour_min, new Object[]{d[0], d[1]});
    }

    public static String b(Date date) {
        Context a = BraceletApp.a();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        C0596r.e(e, "dateFormat.format(date)24\u65f6\u5236: " + simpleDateFormat.format(date));
        if (!DateFormat.is24HourFormat(a)) {
            if (c(date)) {
                simpleDateFormat.applyPattern(a.getString(r.detial_ampm_format));
                C0596r.e(e, "dateFormat.format(date)\u51cc\u6668: " + simpleDateFormat.format(date));
            } else {
                simpleDateFormat.applyPattern(a.getString(r.ampm_format));
                C0596r.e(e, "dateFormat.format(date)\u4e0a\u5348: " + simpleDateFormat.format(date));
            }
        }
        return simpleDateFormat.format(date);
    }

    public static boolean c(Date date) {
        String format = new SimpleDateFormat("HH:mm").format(date);
        return (Integer.parseInt(new StringBuilder().append(com.xiaomi.e.a.f).append(format.charAt(1)).toString()) >= 6 || Integer.parseInt(com.xiaomi.e.a.f + format.charAt(0)) != 0 || Utils.m()) ? d : true;
    }

    public static String[] c(int i) {
        if (i < 0) {
            i += c;
        }
        String[] strArr = new String[]{String.valueOf(i / b), String.valueOf(i % b)};
        if (i / b < 10) {
            strArr[0] = Constants.VIA_RESULT_SUCCESS + strArr[0];
        }
        if (r1 < 10) {
            strArr[1] = Constants.VIA_RESULT_SUCCESS + strArr[1];
        }
        return strArr;
    }

    public static String[] d(int i) {
        String[] strArr = new String[]{String.valueOf(i / b), String.valueOf(i % b)};
        if (i % b < 10) {
            strArr[1] = Constants.VIA_RESULT_SUCCESS + strArr[1];
        }
        return strArr;
    }

    public static String[] e(int i) {
        String[] strArr = new String[]{String.valueOf(i / b), String.valueOf(i % b)};
        if (i / b > 0 && r1 < 10) {
            strArr[1] = Constants.VIA_RESULT_SUCCESS + strArr[1];
        }
        return strArr;
    }
}
