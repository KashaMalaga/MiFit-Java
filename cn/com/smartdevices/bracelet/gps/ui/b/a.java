package cn.com.smartdevices.bracelet.gps.ui.b;

import android.content.Context;
import android.text.Html;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.tencent.connect.common.Constants;
import com.xiaomi.hm.health.b.a.n;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public final class a {
    private static final String a = ":";

    private a() {
    }

    public static int a(String str) {
        int length = str.length();
        return (Integer.parseInt(str.substring(0, length - 4)) * 60) + Integer.parseInt(str.substring(length - 3, length - 1));
    }

    public static CharSequence a(Context context, int i, Object... objArr) {
        return Html.fromHtml(context.getResources().getString(i, objArr));
    }

    public static String a(float f) {
        if (f <= 0.0f) {
            return "0.00";
        }
        if (f < CropOverlayView.a) {
            return String.format("%.2f", new Object[]{Float.valueOf(f)});
        } else if (f >= 1000.0f) {
            return com.xiaomi.e.a.f + ((int) f);
        } else {
            return String.format("%.1f", new Object[]{Float.valueOf(f)});
        }
    }

    public static String a(int i) {
        return HeartRateInfo.isHRValueValid(i) ? String.valueOf(i) : "--";
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

    public static String a(long j, String str, boolean z) {
        if (j <= 0) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        if (z) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(1000 * j);
        return simpleDateFormat.format(instance.getTime());
    }

    public static String a(long j, boolean z) {
        String a = a(j, "HH:mm:ss", z);
        return a == null ? "00:00:00" : a;
    }

    public static String a(Context context, long j) {
        if (context == null || j < 0) {
            return com.xiaomi.e.a.f;
        }
        Calendar.getInstance().setTimeInMillis(1000 * j);
        return context.getResources().getString(n.running_history_date, new Object[]{Integer.valueOf(r0.get(2) + 1), Integer.valueOf(r0.get(5)), Integer.valueOf(r0.get(1))});
    }

    public static int b(long j) {
        return (int) (j / 60);
    }

    public static String b(float f) {
        return a(f);
    }

    public static String b(Context context, long j) {
        if (context == null || j < 0) {
            return context.getString(n.running_sec, new Object[]{Integer.valueOf(0)});
        }
        long j2 = (j % 3600) / 60;
        long j3 = j % 60;
        if (j / 3600 <= 0) {
            if (j2 > 0 && j3 <= 0) {
                return context.getString(n.running_min, new Object[]{Long.valueOf(j2)});
            } else if (j2 <= 0) {
                return context.getString(n.running_sec, new Object[]{Long.valueOf(j3)});
            } else {
                return context.getString(n.running_min_sec, new Object[]{Long.valueOf(j2), Long.valueOf(j3)});
            }
        } else if (j2 > 0 && j3 <= 0) {
            return context.getString(n.running_hour_min, new Object[]{Long.valueOf(r0), Long.valueOf(j2)});
        } else if (j2 <= 0 && j3 <= 0) {
            return context.getString(n.running_hour, new Object[]{Long.valueOf(r0)});
        } else if (j2 > 0 || j3 <= 0) {
            return context.getString(n.running_hour_min_sec, new Object[]{Long.valueOf(r0), Long.valueOf(j2), Long.valueOf(j3)});
        } else {
            return context.getString(n.running_sec, new Object[]{Long.valueOf(r0), Long.valueOf(j3)});
        }
    }

    public static String c(float f) {
        return b(f / 1000.0f);
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

    public static String c(Context context, long j) {
        if (context == null || j < 0) {
            return context.getString(n.running_hour_min_sec, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        }
        long j2 = j / 3600;
        long j3 = (j % 3600) / 60;
        long j4 = j % 60;
        return context.getString(n.running_hour_min_sec, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)});
    }
}
