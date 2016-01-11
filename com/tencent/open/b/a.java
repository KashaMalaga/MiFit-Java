package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.activeandroid.b;
import com.tencent.open.a.f;

public class a {
    protected static final String a = a.class.getName();
    protected static final Uri b = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int d = d(context);
        if (d == 2) {
            return "wifi";
        }
        if (d == 1) {
            return "cmwap";
        }
        if (d == 4) {
            return "cmnet";
        }
        if (d == 16) {
            return "uniwap";
        }
        if (d == 8) {
            return "uninet";
        }
        if (d == 64) {
            return "wap";
        }
        if (d == 32) {
            return "net";
        }
        if (d == C0113o.j) {
            return "ctwap";
        }
        if (d == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            return "ctnet";
        }
        if (d == C0113o.l) {
            return "3gnet";
        }
        if (d == b.a) {
            return "3gwap";
        }
        String b = b(context);
        return (b == null || b.length() == 0) ? "none" : b;
    }

    public static String b(Context context) {
        try {
            Cursor query = context.getContentResolver().query(b, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("apn"));
            if (query == null) {
                return string;
            }
            query.close();
            return string;
        } catch (SecurityException e) {
            f.e(a, "getApn has exception: " + e.getMessage());
            return com.xiaomi.e.a.f;
        }
    }

    public static String c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(b, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            if (query == null) {
                return string;
            }
            query.close();
            return string;
        } catch (SecurityException e) {
            f.e(a, "getApnProxy has exception: " + e.getMessage());
            return com.xiaomi.e.a.f;
        }
    }

    public static int d(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return C0113o.h;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return C0113o.h;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
                return 2;
            }
            String toLowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (toLowerCase.startsWith("cmwap")) {
                return 1;
            }
            if (toLowerCase.startsWith("cmnet") || toLowerCase.startsWith("epc.tmobile.com")) {
                return 4;
            }
            if (toLowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (toLowerCase.startsWith("uninet")) {
                return 8;
            }
            if (toLowerCase.startsWith("wap")) {
                return 64;
            }
            if (toLowerCase.startsWith("net")) {
                return 32;
            }
            if (toLowerCase.startsWith("ctwap")) {
                return C0113o.j;
            }
            if (toLowerCase.startsWith("ctnet")) {
                return PersonInfo.INCOMING_CALL_DISABLE_BIT;
            }
            if (toLowerCase.startsWith("3gwap")) {
                return b.a;
            }
            if (toLowerCase.startsWith("3gnet")) {
                return C0113o.l;
            }
            if (toLowerCase.startsWith("#777")) {
                toLowerCase = c(context);
                return (toLowerCase == null || toLowerCase.length() <= 0) ? PersonInfo.INCOMING_CALL_DISABLE_BIT : C0113o.j;
            }
            return C0113o.h;
        } catch (Exception e) {
            f.e(a, "getMProxyType has exception: " + e.getMessage());
        }
    }

    public static String e(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "MOBILE";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "MOBILE";
    }
}
