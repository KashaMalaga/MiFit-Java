package cn.com.smartdevices.bracelet.shoes.c;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import cn.com.smartdevices.bracelet.C0596r;

public class c {
    private static final String a = "getMobileDataEnabled";
    private static final String b = "NetWorkAssistor";

    private c() {
    }

    private static Object a(Context context, String str, Object[] objArr) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Class cls = connectivityManager.getClass();
        if (objArr == null) {
            return cls.getMethod(str, new Class[0]).invoke(connectivityManager, new Object[0]);
        }
        return cls.getMethod(str, new Class[]{objArr.getClass()}).invoke(connectivityManager, objArr);
    }

    public static boolean a() {
        boolean z = false;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                z = defaultAdapter.isEnabled();
            }
        } catch (Exception e) {
            C0596r.a(b, e.getMessage());
        }
        return z;
    }

    public static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            return ((Boolean) a(context, a, null)).booleanValue();
        } catch (Exception e) {
            C0596r.a(b, e.getMessage());
            return false;
        }
    }

    public static int b(Context context) {
        return context == null ? 0 : WifiManager.calculateSignalLevel(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi(), 5);
    }

    public static boolean c(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo.getType() == 0 && networkInfo.getState() == State.CONNECTED) {
                int subtype = networkInfo.getSubtype();
                if (subtype == 1 || subtype == 4 || subtype == 2 || subtype == 13 || subtype == 6) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        return networkInfo == null ? false : networkInfo.isConnected();
    }

    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        return (networkInfo == null || !networkInfo.isConnected()) ? networkInfo2 != null && networkInfo2.isConnected() : true;
    }

    public static boolean f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().isConnected() : false;
    }

    public static boolean g(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            return networkInfo == null ? false : networkInfo.isConnected();
        } catch (Exception e) {
            C0596r.a(b, e.getMessage());
            return false;
        }
    }
}
