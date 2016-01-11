package com.sina.weibo.sdk.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.app.aT;
import android.text.TextUtils;
import com.xiaomi.e.a;
import java.io.File;

public class NotificationHelper {
    private static final int NOTIFICATION_ID = 1;
    private static final String WEIBO = "Weibo";
    private static final String WEIBO_ZH_CN = "\u5fae\u535a";
    private static final String WEIBO_ZH_TW = "\u5fae\u535a";

    private static PendingIntent buildInstallApkIntent(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return PendingIntent.getActivity(context, 0, new Intent(), 16);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        return PendingIntent.getActivity(context, 0, intent, 16);
    }

    private static Notification buildNotification(Context context, String str, String str2) {
        String str3 = a.f;
        str3 = a.f;
        CharSequence string = ResourceManager.getString(context, WEIBO, WEIBO_ZH_TW, WEIBO_ZH_TW);
        aT aTVar = new aT(context);
        aTVar.e(true);
        aTVar.a(System.currentTimeMillis());
        aTVar.a(((BitmapDrawable) ResourceManager.getDrawable(context, "ic_com_sina_weibo_sdk_weibo_logo.png")).getBitmap());
        aTVar.a(getNotificationIcon(context));
        aTVar.a(string);
        aTVar.e((CharSequence) str);
        aTVar.b((CharSequence) str);
        aTVar.a(buildInstallApkIntent(context, str2));
        return aTVar.c();
    }

    private static int getNotificationIcon(Context context) {
        int resourceId = getResourceId(context, "com_sina_weibo_sdk_weibo_logo", "drawable");
        return resourceId > 0 ? resourceId : 17301659;
    }

    private static int getResourceId(Context context, String str, String str2) {
        String packageName = context.getApplicationContext().getPackageName();
        try {
            return context.getPackageManager().getResourcesForApplication(packageName).getIdentifier(str, str2, packageName);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void showNotification(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ((NotificationManager) context.getSystemService("notification")).notify(NOTIFICATION_ID, buildNotification(context, str, str2));
        }
    }
}
