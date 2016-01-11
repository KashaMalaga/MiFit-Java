package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.h.a.C1098e;
import com.xiaomi.h.a.C1112s;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kankan.wheel.widget.a;
import org.json.JSONObject;

public class T {
    public static long a = 0;
    private static LinkedList<Pair<Integer, String>> b = new LinkedList();

    private static int a(Context context, String str, String str2) {
        return str.equals(context.getPackageName()) ? context.getResources().getIdentifier(str2, "drawable", str) : 0;
    }

    private static Notification a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", new Class[]{CharSequence.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{str});
        } catch (Throwable e) {
            c.a(e);
        }
        return notification;
    }

    @SuppressLint({"NewApi"})
    private static Notification a(Context context, C1112s c1112s, byte[] bArr, RemoteViews remoteViews) {
        C1098e m = c1112s.m();
        Builder builder = new Builder(context);
        String[] a = a(context, m);
        builder.setContentTitle(a[0]);
        builder.setContentText(a[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (VERSION.SDK_INT >= 16) {
            builder.setStyle(new BigTextStyle().bigText(a[1]));
        }
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(a(context, c1112s, m, bArr));
        int a2 = a(context, a(c1112s), "mipush_notification");
        int a3 = a(context, a(c1112s), "mipush_small_notification");
        if (a2 <= 0 || a3 <= 0) {
            builder.setSmallIcon(f(context, a(c1112s)));
        } else {
            builder.setLargeIcon(a(context, a2));
            builder.setSmallIcon(a3);
        }
        builder.setAutoCancel(true);
        long currentTimeMillis = System.currentTimeMillis();
        Map s = m.s();
        if (s != null && s.containsKey("ticker")) {
            builder.setTicker((CharSequence) s.get("ticker"));
        }
        if (currentTimeMillis - a > 10000) {
            a = currentTimeMillis;
            int c = e(context, a(c1112s)) ? c(context, a(c1112s)) : m.f;
            builder.setDefaults(c);
            if (!(s == null || (c & 1) == 0)) {
                String str = (String) s.get("sound_uri");
                if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + a(c1112s))) {
                    builder.setDefaults(c ^ 1);
                    builder.setSound(Uri.parse(str));
                }
            }
        }
        return builder.getNotification();
    }

    private static PendingIntent a(Context context, C1112s c1112s, C1098e c1098e, byte[] bArr) {
        if (c1098e == null || TextUtils.isEmpty(c1098e.g)) {
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setComponent(new ComponentName(c1112s.f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(c1098e.q()));
            return PendingIntent.getService(context, 0, intent, 134217728);
        }
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(c1098e.g));
        intent.addFlags(268435456);
        return PendingIntent.getActivity(context, 0, intent, 134217728);
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    public static Bitmap a(Drawable drawable) {
        int i = 1;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    static String a(C1112s c1112s) {
        if ("com.xiaomi.xmsf".equals(c1112s.f)) {
            C1098e m = c1112s.m();
            if (!(m == null || m.s() == null)) {
                String str = (String) m.s().get("miui_package_name");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return c1112s.f;
    }

    public static void a(Context context, C1112s c1112s, byte[] bArr) {
        Notification a;
        int c;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        C1098e m = c1112s.m();
        RemoteViews b = b(context, c1112s, bArr);
        if (VERSION.SDK_INT >= 11) {
            a = a(context, c1112s, bArr, b);
        } else {
            Notification notification = new Notification(f(context, a(c1112s)), null, System.currentTimeMillis());
            String[] a2 = a(context, m);
            notification.setLatestEventInfo(context, a2[0], a2[1], a(context, c1112s, m, bArr));
            Map s = m.s();
            if (s != null && s.containsKey("ticker")) {
                notification.tickerText = (CharSequence) s.get("ticker");
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a > 10000) {
                a = currentTimeMillis;
                int i = m.f;
                if (e(context, a(c1112s))) {
                    c = c(context, a(c1112s));
                } else {
                    c = i;
                }
                notification.defaults = c;
                if (!(s == null || (c & 1) == 0)) {
                    String str = (String) s.get("sound_uri");
                    if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + a(c1112s))) {
                        notification.defaults = c ^ 1;
                        notification.sound = Uri.parse(str);
                    }
                }
            }
            notification.flags |= 16;
            if (b != null) {
                notification.contentView = b;
            }
            a = notification;
        }
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            a(a, a(c1112s));
        }
        c = m.q() + ((a(c1112s).hashCode() / 10) * 10);
        notificationManager.notify(c, a);
        Pair pair = new Pair(Integer.valueOf(c), a(c1112s));
        synchronized (b) {
            b.add(pair);
            if (b.size() > 100) {
                b.remove();
            }
        }
    }

    public static void a(Context context, String str, int i) {
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        ((NotificationManager) context.getSystemService("notification")).cancel(hashCode);
        synchronized (b) {
            Iterator it = b.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (hashCode == ((Integer) pair.first).intValue() && TextUtils.equals(str, (CharSequence) pair.second)) {
                    b.remove(pair);
                    break;
                }
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            return (runningTasks == null || runningTasks.isEmpty()) ? false : ((RunningTaskInfo) runningTasks.get(0)).topActivity.getPackageName().equals(str);
        } catch (Throwable e) {
            c.a(e);
            return false;
        }
    }

    public static boolean a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return Constants.VIA_TO_TYPE_QQ_GROUP.equals((String) map.get("notify_foreground"));
    }

    private static String[] a(Context context, C1098e c1098e) {
        String h = c1098e.h();
        String j = c1098e.j();
        Map s = c1098e.s();
        if (s != null) {
            int intValue = Float.valueOf((((float) context.getResources().getDisplayMetrics().widthPixels) / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            String str;
            if (intValue <= a.by) {
                str = (String) s.get("title_short");
                if (!TextUtils.isEmpty(str)) {
                    h = str;
                }
                CharSequence charSequence = (String) s.get("description_short");
                if (TextUtils.isEmpty(charSequence)) {
                    Object obj = j;
                }
                j = charSequence;
            } else if (intValue > cn.com.smartdevices.bracelet.gps.c.a.e) {
                str = (String) s.get("title_long");
                if (!TextUtils.isEmpty(str)) {
                    h = str;
                }
                str = (String) s.get("description_long");
                if (!TextUtils.isEmpty(str)) {
                    j = str;
                }
            }
        }
        return new String[]{h, j};
    }

    private static RemoteViews b(Context context, C1112s c1112s, byte[] bArr) {
        C1098e m = c1112s.m();
        String a = a(c1112s);
        Map s = m.s();
        if (s == null) {
            return null;
        }
        String str = (String) s.get("layout_name");
        String str2 = (String) s.get("layout_value");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a);
            int identifier = resourcesForApplication.getIdentifier(str, "layout", a);
            if (identifier == 0) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(a, identifier);
            try {
                JSONObject jSONObject;
                Iterator keys;
                JSONObject jSONObject2 = new JSONObject(str2);
                if (jSONObject2.has("text")) {
                    jSONObject = jSONObject2.getJSONObject("text");
                    keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        CharSequence string = jSONObject.getString(str);
                        identifier = resourcesForApplication.getIdentifier(str, SyncShoesDataService.d, a);
                        if (identifier > 0) {
                            remoteViews.setTextViewText(identifier, string);
                        }
                    }
                }
                if (jSONObject2.has("image")) {
                    jSONObject = jSONObject2.getJSONObject("image");
                    keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        String string2 = jSONObject.getString(str);
                        identifier = resourcesForApplication.getIdentifier(str, SyncShoesDataService.d, a);
                        int identifier2 = resourcesForApplication.getIdentifier(string2, "drawable", a);
                        if (identifier > 0) {
                            remoteViews.setImageViewResource(identifier, identifier2);
                        }
                    }
                }
                if (jSONObject2.has(g.f)) {
                    jSONObject2 = jSONObject2.getJSONObject(g.f);
                    keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        str2 = jSONObject2.getString(str);
                        if (str2.length() == 0) {
                            str2 = "yy-MM-dd hh:mm";
                        }
                        identifier = resourcesForApplication.getIdentifier(str, SyncShoesDataService.d, a);
                        if (identifier > 0) {
                            remoteViews.setTextViewText(identifier, new SimpleDateFormat(str2).format(new Date(System.currentTimeMillis())));
                        }
                    }
                }
                return remoteViews;
            } catch (Throwable e) {
                c.a(e);
                return null;
            }
        } catch (Throwable e2) {
            c.a(e2);
            return null;
        }
    }

    public static void b(Context context, String str) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        synchronized (b) {
            Iterator it = ((LinkedList) b.clone()).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (TextUtils.equals((CharSequence) pair.second, str)) {
                    notificationManager.cancel(((Integer) pair.first).intValue());
                    b.remove(pair);
                }
            }
        }
    }

    static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    static int c(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    static void d(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    static boolean e(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    private static int f(Context context, String str) {
        int a = a(context, str, "mipush_notification");
        int a2 = a(context, str, "mipush_small_notification");
        if (a <= 0) {
            a = a2 > 0 ? a2 : context.getApplicationInfo().icon;
        }
        return (a != 0 || VERSION.SDK_INT < 9) ? a : context.getApplicationInfo().logo;
    }
}
