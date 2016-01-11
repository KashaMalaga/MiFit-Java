package android.support.v4.f;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public class a {
    private static final c a;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new f();
        } else if (VERSION.SDK_INT >= 13) {
            a = new e();
        } else if (VERSION.SDK_INT >= 8) {
            a = new d();
        } else {
            a = new b();
        }
    }

    public static NetworkInfo a(ConnectivityManager connectivityManager, Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        return networkInfo != null ? connectivityManager.getNetworkInfo(networkInfo.getType()) : null;
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        return a.a(connectivityManager);
    }
}
