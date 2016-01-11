package b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.support.v4.view.a.C0113o;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.activeandroid.b;
import com.d.a.a.C1012a;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.microedition.khronos.opengles.GL10;

public class bW {
    protected static final String a = bW.class.getName();
    public static final String b = "";
    public static final String c = "2G/3G";
    public static final String d = "Wi-Fi";
    public static final int e = 8;

    private static int a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int a(Date date, Date date2) {
        if (!date.after(date2)) {
            Date date3 = date2;
            date2 = date;
            date = date3;
        }
        return (int) ((date.getTime() - date2.getTime()) / 1000);
    }

    public static String a() {
        String str = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            if (fileReader != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, b.a);
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (Exception e) {
                    bX.b(a, "Could not read from file /proc/cpuinfo", e);
                }
            }
        } catch (Exception e2) {
            bX.b(a, "Could not open file /proc/cpuinfo", e2);
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : b;
    }

    public static String a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
    }

    public static Date a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean a(Context context) {
        return context.getResources().getConfiguration().locale.toString().equals(Locale.CHINA.toString());
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean a(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static String[] a(GL10 gl10) {
        try {
            String[] strArr = new String[2];
            String glGetString = gl10.glGetString(7936);
            String glGetString2 = gl10.glGetString(7937);
            strArr[0] = glGetString;
            strArr[1] = glGetString2;
            return strArr;
        } catch (Exception e) {
            bX.b(a, "Could not read gpu infor:", e);
            return new String[0];
        }
    }

    public static boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean b(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static String c() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
    }

    public static String c(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (NameNotFoundException e) {
            return b;
        }
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return b;
        }
    }

    public static String e(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : b);
    }

    public static String f(Context context) {
        Object deviceId;
        String string;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            bX.e(a, "No IMEI.");
        }
        String str = b;
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                deviceId = telephonyManager.getDeviceId();
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                bX.e(a, "No IMEI.");
                deviceId = p(context);
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                bX.e(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                string = Secure.getString(context.getContentResolver(), "android_id");
                bX.a(a, "getDeviceId: Secure.ANDROID_ID: " + string);
                return string;
            }
        } catch (Exception e) {
            bX.e(a, "No IMEI.", e);
        }
        string = str;
        if (TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        bX.e(a, "No IMEI.");
        deviceId = p(context);
        if (TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        bX.e(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
        string = Secure.getString(context.getContentResolver(), "android_id");
        bX.a(a, "getDeviceId: Secure.ANDROID_ID: " + string);
        return string;
    }

    public static String g(Context context) {
        return C0352cm.b(f(context));
    }

    public static String h(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? b : telephonyManager.getNetworkOperatorName();
        } catch (Exception e) {
            e.printStackTrace();
            return b;
        }
    }

    public static String i(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return new StringBuilder(String.valueOf(String.valueOf(displayMetrics.heightPixels))).append("*").append(String.valueOf(displayMetrics.widthPixels)).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return b;
        }
    }

    public static String[] j(Context context) {
        String[] strArr = new String[]{b, b};
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                strArr[0] = b;
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = b;
                return strArr;
            } else if (connectivityManager.getNetworkInfo(1).getState() == State.CONNECTED) {
                strArr[0] = d;
                return strArr;
            } else {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo.getState() == State.CONNECTED) {
                    strArr[0] = c;
                    strArr[1] = networkInfo.getSubtypeName();
                    return strArr;
                }
                return strArr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean k(Context context) {
        return d.equals(j(context)[0]);
    }

    public static boolean l(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false;
        } catch (Exception e) {
            return true;
        }
    }

    public static int m(Context context) {
        try {
            Calendar instance = Calendar.getInstance(x(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Exception e) {
            bX.a(a, "error in getTimeZone", e);
        }
        return e;
    }

    public static String[] n(Context context) {
        String[] strArr = new String[2];
        try {
            Locale x = x(context);
            if (x != null) {
                strArr[0] = x.getCountry();
                strArr[1] = x.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
        } catch (Exception e) {
            bX.b(a, "error in getLocaleInfo", e);
        }
        return strArr;
    }

    public static String o(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                bX.b(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            bX.b(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", e);
        }
        return null;
    }

    public static String p(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            bX.e(a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return b;
        } catch (Exception e) {
            bX.e(a, "Could not get mac address." + e.toString());
        }
    }

    public static String q(Context context) {
        int[] r = r(context);
        if (r == null) {
            return "Unknown";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(r[0]);
        stringBuffer.append("*");
        stringBuffer.append(r[1]);
        return stringBuffer.toString();
    }

    public static int[] r(Context context) {
        try {
            int a;
            int a2;
            int i;
            Object displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & C1012a.e) == 0) {
                a = a(displayMetrics, "noncompatWidthPixels");
                a2 = a(displayMetrics, "noncompatHeightPixels");
            } else {
                a2 = -1;
                a = -1;
            }
            if (a == -1 || a2 == -1) {
                i = displayMetrics.widthPixels;
                a = displayMetrics.heightPixels;
            } else {
                i = a;
                a = a2;
            }
            int[] iArr = new int[2];
            if (i > a) {
                iArr[0] = a;
                iArr[1] = i;
                return iArr;
            }
            iArr[0] = i;
            iArr[1] = a;
            return iArr;
        } catch (Exception e) {
            bX.b(a, "read resolution fail", e);
            return null;
        }
    }

    public static String s(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Exception e) {
            bX.a(a, "read carrier fail", e);
            return "Unknown";
        }
    }

    public static String t(Context context) {
        String str = "Unknown";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("UMENG_CHANNEL");
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (obj2 != null) {
                        return obj2;
                    }
                    bX.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
                    return str;
                }
            }
        } catch (Exception e) {
            bX.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            e.printStackTrace();
        }
        return str;
    }

    public static String u(Context context) {
        return context.getPackageName();
    }

    public static String v(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static boolean w(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    private static Locale x(Context context) {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Exception e) {
            bX.b(a, "fail to read user config locale");
        }
        return locale == null ? Locale.getDefault() : locale;
    }
}
