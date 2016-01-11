package cn.com.smartdevices.bracelet.lab.b;

import android.content.Context;
import android.text.Html;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.r;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public final class f {
    private static final String a = ":";

    private f() {
    }

    public static CharSequence a(Context context, int i, Object... objArr) {
        return Html.fromHtml(context.getResources().getString(i, objArr));
    }

    public static String a(long j) {
        if (j <= 0) {
            return "00'00\"";
        }
        long j2 = ((j / 3600) * 60) + ((j % 3600) / 60);
        long j3 = j % 60;
        StringBuffer stringBuffer = new StringBuffer();
        if (j2 <= 0) {
            stringBuffer.append("00'");
        } else if (j2 < 10) {
            stringBuffer.append(Constants.VIA_RESULT_SUCCESS).append(j2).append("'");
        } else {
            stringBuffer.append(j2).append("'");
        }
        if (j3 <= 0) {
            stringBuffer.append("00\"");
        } else if (j3 < 10) {
            stringBuffer.append(Constants.VIA_RESULT_SUCCESS).append(j3).append("\"");
        } else {
            stringBuffer.append(j3).append("\"");
        }
        return stringBuffer.toString();
    }

    public static String a(long j, boolean z) {
        if (j <= 0) {
            return "00:00:00";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        if (z) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(1000 * j);
        return simpleDateFormat.format(instance.getTime());
    }

    public static String a(Context context, long j) {
        if (context == null || j < 0) {
            return context.getString(r.lab_factory_sport_sec, new Object[]{Integer.valueOf(0)});
        }
        long j2 = (j % 3600) / 60;
        long j3 = j % 60;
        if (j / 3600 <= 0) {
            if (j2 > 0 && j3 <= 0) {
                return context.getString(r.lab_factory_sport_min, new Object[]{Long.valueOf(j2)});
            } else if (j2 <= 0) {
                return context.getString(r.lab_factory_sport_sec, new Object[]{Long.valueOf(j3)});
            } else {
                return context.getString(r.lab_factory_sport_min_sec, new Object[]{Long.valueOf(j2), Long.valueOf(j3)});
            }
        } else if (j2 > 0 && j3 <= 0) {
            return context.getString(r.lab_factory_sport_hour_min, new Object[]{Long.valueOf(r0), Long.valueOf(j2)});
        } else if (j2 <= 0 && j3 <= 0) {
            return context.getString(r.lab_factory_sport_hour, new Object[]{Long.valueOf(r0)});
        } else if (j2 > 0 || j3 <= 0) {
            return context.getString(r.lab_factory_sport_hour_min_sec, new Object[]{Long.valueOf(r0), Long.valueOf(j2), Long.valueOf(j3)});
        } else {
            return context.getString(r.lab_factory_sport_hour_sec, new Object[]{Long.valueOf(r0), Long.valueOf(j3)});
        }
    }

    public static int b(long j) {
        return (int) (j / 60);
    }

    public static String b(Context context, long j) {
        if (context == null || j < 0) {
            return context.getString(r.lab_factory_sport_hour_min_sec, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        }
        long j2 = (j % 3600) / 60;
        long j3 = j % 60;
        return context.getString(r.lab_factory_sport_hour_min_sec, new Object[]{Long.valueOf(j / 3600), Long.valueOf(j2), Long.valueOf(j3)});
    }

    public static String c(long j) {
        if (j < 0) {
            return "00:00";
        }
        long j2 = j / 3600;
        long j3 = (j % 3600) / 60;
        long j4 = j % 60;
        StringBuffer stringBuffer = new StringBuffer();
        if (j2 <= 0) {
            if (j3 < 10) {
                stringBuffer.append(Constants.VIA_RESULT_SUCCESS).append(j3);
            } else {
                stringBuffer.append(j3);
            }
            stringBuffer.append(a);
            if (j4 < 10) {
                stringBuffer.append(Constants.VIA_RESULT_SUCCESS).append(j4);
            } else {
                stringBuffer.append(j4);
            }
        } else {
            if (j2 < 10) {
                stringBuffer.append(Constants.VIA_RESULT_SUCCESS).append(j2);
            } else {
                stringBuffer.append(j2);
            }
            stringBuffer.append(a);
            if (j3 < 10) {
                stringBuffer.append(Constants.VIA_RESULT_SUCCESS).append(j3).append(a);
            } else {
                stringBuffer.append(j3).append(a);
            }
            if (j4 < 10) {
                stringBuffer.append(Constants.VIA_RESULT_SUCCESS).append(j4);
            } else {
                stringBuffer.append(j4);
            }
        }
        return stringBuffer.toString();
    }
}
