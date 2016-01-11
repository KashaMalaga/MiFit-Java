package cn.com.smartdevices.bracelet.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v7.widget.af;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.model.DeviceInfo;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.SystemInfo;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.d.a.a.O;
import com.d.a.a.h;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.Header;

@SuppressLint({"NewApi"})
public class j {
    static SystemInfo a(Context context) {
        String str;
        String valueOf = String.valueOf(VERSION.SDK_INT);
        String str2 = a.f;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            str = a.f;
        }
        return new SystemInfo(e(context), d(context), Build.BRAND, Build.MODEL, valueOf, str);
    }

    public static String a(Context context, String str) {
        String str2 = a.f;
        try {
            Class loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", new Class[]{String.class}).invoke(loadClass, new Object[]{str});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            return a.f;
        }
    }

    public static void a(Context context, DeviceInfo deviceInfo, h hVar, boolean z) {
        if (context != null) {
            SystemInfo a = a(context);
            if (a != null) {
                LoginData f = cn.com.smartdevices.bracelet.e.a.f(context);
                if (f.isValid()) {
                    O a2 = f.a(f);
                    if (deviceInfo != null) {
                        a2.a(f.aa, a.f + deviceInfo.getType());
                        a2.a(g.t, deviceInfo.getDeviceId());
                        try {
                            a2.a(g.q, URLEncoder.encode(deviceInfo.getMacAddress(), h.DEFAULT_CHARSET));
                        } catch (UnsupportedEncodingException e) {
                        }
                        a2.a(f.ag, deviceInfo.getFwVersion());
                        a2.a(o.L, deviceInfo.getSource());
                        if (!TextUtils.isEmpty(deviceInfo.getHRFwVersion())) {
                            a2.a(f.ai, deviceInfo.getHRFwVersion());
                        }
                    }
                    a2.a(f.ab, a.getMiuiVersionCode());
                    a2.a(f.ac, a.getMiuiVersionName());
                    a2.a(f.ad, a.getPhoneBrand());
                    a2.a(f.ae, a.getPhoneModel());
                    a2.a(f.af, a.getPhoneSystem());
                    a2.a(f.ak, a.getSoftVersion());
                    String a3 = e.a(g.g);
                    if (z) {
                        a.b(d.a, a3, a2, hVar);
                        return;
                    } else {
                        a.b(d.b, a3, a2, hVar);
                        return;
                    }
                }
                f.getClass();
                hVar.onFailure(af.a, new Header[0], new byte[0], new Throwable());
            }
        }
    }

    public static String b(Context context) {
        return a(context, "ro.build.date.utc");
    }

    public static String c(Context context) {
        return a(context, "ro.build.version.incremental");
    }

    public static String d(Context context) {
        return a(context, "ro.miui.ui.version.code");
    }

    public static String e(Context context) {
        return a(context, "ro.miui.ui.version.name");
    }
}
