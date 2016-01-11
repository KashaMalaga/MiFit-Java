package com.b;

public final class I {
    protected static boolean a = false;
    protected static final String[] b = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE"};

    protected static boolean a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
