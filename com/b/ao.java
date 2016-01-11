package com.b;

import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.widget.Toast;
import com.amap.api.location.core.c;
import com.tencent.connect.common.Constants;
import com.xiaomi.mipush.sdk.f;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import kankan.wheel.widget.a;
import org.apache.http.params.HttpParams;

public class ao {
    private ao() {
    }

    static float a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    static int a(int i) {
        return (i * 2) - 113;
    }

    static int a(CellLocation cellLocation, Context context) {
        if (a(context)) {
            a("air plane mode on");
            return 9;
        } else if (cellLocation instanceof GsmCellLocation) {
            return 1;
        } else {
            try {
                Class.forName("android.telephony.cdma.CdmaCellLocation");
                return 2;
            } catch (Throwable th) {
                th.printStackTrace();
                a(th);
                return 9;
            }
        }
    }

    static long a() {
        return System.currentTimeMillis();
    }

    static void a(Context context, String str) {
        int i;
        if (str == null) {
            CharSequence charSequence = "null";
        }
        if (c.j().indexOf(a.ah) != -1) {
            i = 1;
        } else if (Q.d.indexOf(a.ah) != -1) {
            i = 1;
        } else {
            char[] cArr = null;
            if (c.j().length() > 0) {
                cArr = c.j().substring(7, 8).toCharArray();
            }
            i = (cArr == null || !Character.isLetter(cArr[0])) ? 1 : 0;
        }
        if (i != 0 && context != null) {
            Toast.makeText(context, charSequence, 0).show();
            a(charSequence);
        }
    }

    public static void a(Throwable th) {
    }

    static void a(HttpParams httpParams, int i) {
        httpParams.setIntParameter("http.connection.timeout", i);
        httpParams.setIntParameter("http.socket.timeout", i);
        httpParams.setLongParameter("http.conn-manager.timeout", (long) i);
    }

    public static void a(Object... objArr) {
    }

    static boolean a(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (b() < 17) {
            try {
                if (System.getInt(contentResolver, "airplane_mode_on", 0) != 1) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                th.printStackTrace();
                a(th);
                return false;
            }
        }
        try {
            if (Global.getInt(contentResolver, "airplane_mode_on", 0) != 1) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            th2.printStackTrace();
            a(th2);
            return false;
        }
    }

    static boolean a(M m) {
        if (m == null || m.j().equals(Constants.VIA_SHARE_TYPE_TEXT) || m.j().equals(Constants.VIA_SHARE_TYPE_INFO)) {
            return false;
        }
        return (m.e() == 0.0d && m.f() == 0.0d && ((double) m.g()) == 0.0d) ? false : true;
    }

    public static boolean a(String str) {
        return (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) ? ",111,123,134,199,202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,560,598,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,665,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,850,901,".contains(f.i + str + f.i) : false;
    }

    public static byte[] a(byte[] bArr) {
        byte[] toByteArray;
        Throwable th;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return toByteArray;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            toByteArray = null;
            th = th4;
            th.printStackTrace();
            return toByteArray;
        }
        return toByteArray;
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i = 1;
        int i2 = 0;
        String[] strArr = new String[]{Constants.VIA_RESULT_SUCCESS, Constants.VIA_RESULT_SUCCESS};
        Object obj = null;
        if (telephonyManager != null) {
            try {
                obj = telephonyManager.getNetworkOperator();
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(obj)) {
            i = i2;
        } else if (!TextUtils.isDigitsOnly(obj)) {
            i = i2;
        } else if (obj.length() <= 4) {
            i = i2;
        }
        if (i != 0) {
            strArr[0] = obj.substring(0, 3);
            char[] toCharArray = obj.substring(3).toCharArray();
            i = i2;
            while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                i++;
            }
            strArr[1] = obj.substring(3, i + 3);
        }
        try {
            i2 = Integer.parseInt(strArr[0]);
        } catch (Exception e2) {
        }
        if (i2 == 0) {
            strArr[0] = Constants.VIA_RESULT_SUCCESS;
        }
        return strArr;
    }

    static int b() {
        int i = 0;
        try {
            return VERSION.SDK_INT;
        } catch (Throwable th) {
            th.printStackTrace();
            a(th);
            return i;
        }
    }

    static NetworkInfo b(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b(context, "connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException e) {
                return null;
            }
        }
        activeNetworkInfo = null;
        return activeNetworkInfo;
    }

    static Object b(Context context, String str) {
        return context == null ? null : context.getApplicationContext().getSystemService(str);
    }
}
