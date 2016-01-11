package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.view.a.C0113o;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.security.MessageDigest;
import java.util.Locale;

public class w {
    private static String a = a.f;
    private static String b = null;
    private static String c = a.f;
    private static String d;
    private static String e = null;

    public static String a(Context context) {
        try {
            if (!a.f.equals(a)) {
                return a;
            }
            PackageManager packageManager = context.getPackageManager();
            a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return a;
        } catch (Throwable e) {
            az.a(e, "AppInfo", "getApplicationName");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.a(e2, "AppInfo", "getApplicationName");
            e2.printStackTrace();
        }
    }

    static void a(String str) {
        d = str;
    }

    public static String b(Context context) {
        try {
            if (b != null && !a.f.equals(b)) {
                return b;
            }
            b = context.getApplicationContext().getPackageName();
            return b;
        } catch (Throwable th) {
            az.a(th, "AppInfo", "getPackageName");
            th.printStackTrace();
        }
    }

    public static String c(Context context) {
        try {
            if (!a.f.equals(c)) {
                return c;
            }
            c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return c;
        } catch (Throwable e) {
            az.a(e, "AppInfo", "getApplicationVersion");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.a(e2, "AppInfo", "getApplicationVersion");
            e2.printStackTrace();
        }
    }

    public static String d(Context context) {
        try {
            if (e != null && !a.f.equals(e)) {
                return e;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance("SHA1").digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toUpperCase = Integer.toHexString(b & HeartRateInfo.HR_EMPTY_VALUE).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append(Constants.VIA_RESULT_SUCCESS);
                }
                stringBuffer.append(toUpperCase);
                stringBuffer.append(kankan.wheel.widget.a.ci);
            }
            stringBuffer.append(packageInfo.packageName);
            e = stringBuffer.toString();
            return e;
        } catch (Throwable e) {
            az.a(e, "AppInfo", "getSHA1AndPackage");
            e.printStackTrace();
            return e;
        } catch (Throwable e2) {
            az.a(e2, "AppInfo", "getSHA1AndPackage");
            e2.printStackTrace();
            return e;
        } catch (Throwable e22) {
            az.a(e22, "AppInfo", "getSHA1AndPackage");
            e22.printStackTrace();
            return e;
        }
    }

    public static String e(Context context) {
        try {
            return g(context);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return d;
        } catch (Throwable th) {
            th.printStackTrace();
            return d;
        }
    }

    public static String f(Context context) {
        try {
            return g(context);
        } catch (Throwable e) {
            az.a(e, "AppInfo", "getKey");
            e.printStackTrace();
            return d;
        } catch (Throwable e2) {
            az.a(e2, "AppInfo", "getKey");
            e2.printStackTrace();
            return d;
        }
    }

    private static String g(Context context) {
        if (d == null || d.equals(a.f)) {
            d = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h).metaData.getString("com.amap.api.v2.apikey");
        }
        return d;
    }
}
