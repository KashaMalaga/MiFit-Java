package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.xiaomi.e.a;

public class C {
    private static final String a = "NetworkState";

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().isConnected() : false;
    }

    public static String b(Context context) {
        String str = a.f;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
            return C0401a.hD;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return C0401a.hC;
        }
        if (type == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 4 || subtype == 1 || subtype == 2) {
                return C0401a.hz;
            }
            if (subtype == 3 || subtype == 8 || subtype == 6 || subtype == 5 || subtype == 12) {
                return C0401a.hA;
            }
            if (subtype == 13) {
                return C0401a.hB;
            }
        }
        return str;
    }

    public static void c(Context context) {
        if (context != null && Keeper.getEnterAppTrace() != 0) {
            String b = b(context);
            C0596r.d(a, "enter app trace = " + Keeper.getEnterAppTrace() + " , netType = " + b);
            C0401a.a(context, C0401a.hy, b);
            Keeper.setEnterAppTrace(0);
        }
    }
}
