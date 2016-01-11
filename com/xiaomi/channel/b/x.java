package com.xiaomi.channel.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.List;

public class x {
    public static final int a = -10001;
    public static final int b = -10002;
    public static final int c = 100;
    private static final String d = "com.xiaomi.channel";

    public static int a(Context context) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages == null) {
            return a;
        }
        int i = 0;
        while (i < installedPackages.size()) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            if (d.equals(packageInfo.packageName)) {
                return packageInfo.versionCode >= v.a ? c : b;
            } else {
                i++;
            }
        }
        return a;
    }

    public static boolean a(Context context, int i) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages == null) {
            return false;
        }
        int i2 = 0;
        while (i2 < installedPackages.size()) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i2);
            if (d.equals(packageInfo.packageName)) {
                return packageInfo.versionCode >= i;
            } else {
                i2++;
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages == null) {
            return false;
        }
        int i = 0;
        while (i < installedPackages.size()) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            if (d.equals(packageInfo.packageName)) {
                return packageInfo.versionCode >= v.a;
            } else {
                i++;
            }
        }
        return false;
    }

    public static int c(Context context) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages == null) {
            return 0;
        }
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            if (d.equals(packageInfo.packageName)) {
                return packageInfo.versionCode;
            }
        }
        return 0;
    }

    public static boolean d(Context context) {
        PackageInfo packageInfo;
        String str = d;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(d, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }
}
