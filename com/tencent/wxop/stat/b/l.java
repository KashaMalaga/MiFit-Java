package com.tencent.wxop.stat.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.support.v4.g.c;
import android.support.v4.view.a.C0113o;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.activeandroid.b;
import com.d.a.a.C1012a;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.mipush.sdk.f;
import com.xiaomi.mistatistic.sdk.d;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class l {
    private static int U = -1;
    private static String W = null;
    private static String a = null;
    private static String aR = null;
    private static String b = null;
    private static int bG = -1;
    private static volatile int bn = -1;
    private static String bq = null;
    private static String br = a.f;
    private static String bs = a.f;
    private static String c = null;
    private static String cC = null;
    private static String cE = a.f;
    private static Random cR = null;
    private static DisplayMetrics cS = null;
    private static b cT = null;
    private static String cU = null;
    private static String cV = null;
    private static long cW = -1;
    private static o cX = null;
    private static String cY = "__MTA_FIRST_ACTIVATE__";
    private static long cZ = -1;
    private static String da = a.f;
    private static int w = 0;

    public static String A(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                cT.c("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            cT.d("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String B(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String C(Context context) {
        if (bq != null) {
            return bq;
        }
        try {
            if (r.a(context, "android.permission.READ_PHONE_STATE")) {
                if ((context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) != 0 ? null : 1) != null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        bq = telephonyManager.getSimOperator();
                    }
                }
            } else {
                cT.d("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            cT.b(th);
        }
        return bq;
    }

    public static String D(Context context) {
        if (e(br)) {
            return br;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            br = str;
            if (str == null) {
                return a.f;
            }
        } catch (Throwable th) {
            cT.b(th);
        }
        return br;
    }

    public static String E(Context context) {
        String str = a.f;
        try {
            if (r.a(context, "android.permission.INTERNET") && r.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            cT.d("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            cT.b(th);
            return str;
        }
    }

    public static Integer F(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String G(Context context) {
        if (e(bs)) {
            return bs;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            bs = str;
            if (str == null || bs.length() == 0) {
                return c.a;
            }
        } catch (Throwable th) {
            cT.b(th);
        }
        return bs;
    }

    public static String H(Context context) {
        if (e(cU)) {
            return cU;
        }
        try {
            if (r.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
                        cU = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            cT.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            cT.b(th);
        }
    }

    static String I(Context context) {
        try {
            if (aR != null) {
                return aR;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    aR = runningAppProcessInfo.processName;
                    break;
                }
            }
            return aR;
        } catch (Throwable th) {
        }
    }

    public static String J(Context context) {
        return e(context, a.ct);
    }

    public static synchronized Integer K(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (l.class) {
            if (bn <= 0) {
                bn = q.a(context, "MTA_EVENT_INDEX", 0);
                q.b(context, "MTA_EVENT_INDEX", bn + h.E);
            } else if (bn % h.E == 0) {
                try {
                    int i2 = bn + h.E;
                    if (bn < 2147383647) {
                        i = i2;
                    }
                    q.b(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    cT.c(th);
                }
            }
            i = bn + 1;
            bn = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    public static String L(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem / 1000000) + "/" + String.valueOf(ay() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String M(Context context) {
        if (e(cE)) {
            return cE;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(f.i);
                        }
                    }
                    cE = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            cT.b(th);
        }
        return cE;
    }

    public static synchronized int N(Context context) {
        int i;
        synchronized (l.class) {
            if (U != -1) {
                i = U;
            } else {
                O(context);
                i = U;
            }
        }
        return i;
    }

    public static void O(Context context) {
        int a = q.a(context, cY, 1);
        U = a;
        if (a == 1) {
            q.b(context, cY, 0);
        }
    }

    public static boolean P(Context context) {
        if (cZ < 0) {
            cZ = q.f(context, "mta.qq.com.checktime");
        }
        return Math.abs(System.currentTimeMillis() - cZ) > d.h;
    }

    public static void Q(Context context) {
        cZ = System.currentTimeMillis();
        q.a(context, "mta.qq.com.checktime", cZ);
    }

    public static String R(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals(MiPushMessageReceiver.ANDROID)) ? null : resolveActivity.activityInfo.packageName;
    }

    public static int a(Context context, boolean z) {
        if (z) {
            w = q.a(context, "mta.qq.com.difftime", 0);
        }
        return w;
    }

    private static Long a(String str, String str2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != 3) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i = 0;
            while (i < split.length) {
                Long valueOf2 = Long.valueOf(100 * (valueOf.longValue() + Long.valueOf(split[i]).longValue()));
                i++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static void a(Context context, int i) {
        w = i;
        q.b(context, "mta.qq.com.difftime", i);
    }

    public static boolean a(com.tencent.wxop.stat.f fVar) {
        return fVar == null ? false : e(fVar.S());
    }

    public static long ad() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + d.h;
        } catch (Throwable th) {
            cT.b(th);
            return System.currentTimeMillis() + d.h;
        }
    }

    private static synchronized Random at() {
        Random random;
        synchronized (l.class) {
            if (cR == null) {
                cR = new Random();
            }
            random = cR;
        }
        return random;
    }

    public static int au() {
        if (bG != -1) {
            return bG;
        }
        try {
            if (p.a()) {
                bG = 1;
            }
        } catch (Throwable th) {
            cT.b(th);
        }
        bG = 0;
        return 0;
    }

    public static synchronized b av() {
        b bVar;
        synchronized (l.class) {
            if (cT == null) {
                bVar = new b("MtaSDK");
                cT = bVar;
                bVar.ap();
            }
            bVar = cT;
        }
        return bVar;
    }

    public static String aw() {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, 0);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static String ax() {
        if (e(cC)) {
            return cC;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize())) / 1000000) + "/" + String.valueOf(blockCount);
        cC = str;
        return str;
    }

    private static long ay() {
        if (cW > 0) {
            return cW;
        }
        long j = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), C1012a.e);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * b.a);
            bufferedReader.close();
        } catch (Exception e) {
        }
        cW = j;
        return j;
    }

    public static JSONObject az() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", m.r());
            String ax = m.ax();
            if (ax != null && ax.length() > 0) {
                jSONObject.put("na", ax);
            }
            int aA = m.aA();
            if (aA > 0) {
                jSONObject.put("fx", aA / 1000000);
            }
            aA = m.D();
            if (aA > 0) {
                jSONObject.put("fn", aA / 1000000);
            }
        } catch (Throwable th) {
            Log.w("MtaSDK", "get cpu error", th);
        }
        return jSONObject;
    }

    public static byte[] b(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[ChartData.d];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    public static synchronized String c(Context context) {
        String b;
        synchronized (l.class) {
            if (a == null || a.trim().length() == 0) {
                b = r.b(context);
                a = b;
                if (b == null || a.trim().length() == 0) {
                    a = Integer.toString(at().nextInt(Integer.MAX_VALUE));
                }
                b = a;
            } else {
                b = a;
            }
        }
        return b;
    }

    public static String d(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String e(Context context, String str) {
        if (!com.tencent.wxop.stat.c.E()) {
            return str;
        }
        if (aR == null) {
            aR = I(context);
        }
        return aR != null ? str + "_" + aR : str;
    }

    public static boolean e(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static int r() {
        return at().nextInt(Integer.MAX_VALUE);
    }

    public static String t(String str) {
        if (str == null) {
            return Constants.VIA_RESULT_SUCCESS;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & HeartRateInfo.HR_EMPTY_VALUE;
                if (i < 16) {
                    stringBuffer.append(Constants.VIA_RESULT_SUCCESS);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return Constants.VIA_RESULT_SUCCESS;
        }
    }

    public static long u(String str) {
        return a(str, ".", Long.valueOf(0)).longValue();
    }

    public static HttpHost v(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            cT.b(th);
        }
    }

    public static synchronized String w(Context context) {
        String str;
        synchronized (l.class) {
            if (c == null || c.trim().length() == 0) {
                c = r.c(context);
            }
            str = c;
        }
        return str;
    }

    public static DisplayMetrics x(Context context) {
        if (cS == null) {
            cS = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(cS);
        }
        return cS;
    }

    public static boolean y(Context context) {
        try {
            if (r.a(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            cT.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            cT.b(th);
        }
    }

    public static String z(Context context) {
        if (b != null) {
            return b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    b = string;
                    return string;
                }
                cT.b((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            cT.b((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }
}
