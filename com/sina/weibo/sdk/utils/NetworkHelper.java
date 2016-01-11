package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.g.c;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.g.a.p;
import com.huami.android.widget.share.m;
import com.xiaomi.market.sdk.o;
import java.util.List;

public class NetworkHelper {
    public static void clearCookies(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static String generateUA(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p.b);
        stringBuilder.append("__");
        stringBuilder.append(m.b);
        stringBuilder.append("__");
        stringBuilder.append(o.w);
        stringBuilder.append("__");
        try {
            stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", "_"));
        } catch (Exception e) {
            stringBuilder.append(c.a);
        }
        return stringBuilder.toString();
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context, int i) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(i);
    }

    public static int getNetworkType(Context context) {
        if (context == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
    }

    public static DetailedState getWifiConnectivityState(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context, 1);
        return networkInfo == null ? DetailedState.FAILED : networkInfo.getDetailedState();
    }

    public static int getWifiState(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        return wifiManager == null ? 4 : wifiManager.getWifiState();
    }

    public static boolean hasInternetPermission(Context context) {
        return context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static boolean isMobileNetwork(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo != null && activeNetworkInfo.getType() == 0 && activeNetworkInfo.isConnected();
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isWifiValid(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected();
    }

    public static boolean wifiConnection(Context context, String str, String str2) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String str3 = "\"" + str + "\"";
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null && (str.equals(connectionInfo.getSSID()) || str3.equals(connectionInfo.getSSID()))) {
            return true;
        }
        List scanResults = wifiManager.getScanResults();
        if (!(scanResults == null || scanResults.size() == 0)) {
            for (int size = scanResults.size() - 1; size >= 0; size--) {
                String str4 = ((ScanResult) scanResults.get(size)).SSID;
                if (str.equals(str4) || str3.equals(str4)) {
                    WifiConfiguration wifiConfiguration = new WifiConfiguration();
                    wifiConfiguration.SSID = str3;
                    wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                    wifiConfiguration.status = 2;
                    return wifiManager.enableNetwork(wifiManager.addNetwork(wifiConfiguration), false);
                }
            }
        }
        return false;
    }
}
