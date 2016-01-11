package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class C0063by {
    public static final String a = "NotificationCompat";
    static final String b = "android.support.localOnly";
    static final String c = "android.support.actionExtras";
    static final String d = "android.support.remoteInputs";
    static final String e = "android.support.groupKey";
    static final String f = "android.support.isGroupSummary";
    static final String g = "android.support.sortKey";
    static final String h = "android.support.useSideChannel";
    private static final String i = "icon";
    private static final String j = "title";
    private static final String k = "actionIntent";
    private static final String l = "extras";
    private static final String m = "remoteInputs";
    private static final Object n = new Object();
    private static Field o;
    private static boolean p;
    private static final Object q = new Object();
    private static Class<?> r;
    private static Field s;
    private static Field t;
    private static Field u;
    private static Field v;
    private static boolean w;

    C0063by() {
    }

    public static Bundle a(Builder builder, bq bqVar) {
        builder.addAction(bqVar.a(), bqVar.b(), bqVar.c());
        Bundle bundle = new Bundle(bqVar.d());
        if (bqVar.f() != null) {
            bundle.putParcelableArray(d, cc.a(bqVar.f()));
        }
        return bundle;
    }

    public static Bundle a(Notification notification) {
        synchronized (n) {
            if (p) {
                return null;
            }
            try {
                if (o == null) {
                    Field declaredField = Notification.class.getDeclaredField(l);
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        o = declaredField;
                    } else {
                        Log.e(a, "Notification.extras field is not of type Bundle");
                        p = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) o.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    o.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e(a, "Unable to access notification extras", e);
                p = true;
                return null;
            } catch (Throwable e2) {
                Log.e(a, "Unable to access notification extras", e2);
                p = true;
                return null;
            }
        }
    }

    private static Bundle a(bq bqVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(i, bqVar.a());
        bundle.putCharSequence(j, bqVar.b());
        bundle.putParcelable(k, bqVar.c());
        bundle.putBundle(l, bqVar.d());
        bundle.putParcelableArray(m, cc.a(bqVar.f()));
        return bundle;
    }

    public static bq a(Notification notification, int i, br brVar, cb cbVar) {
        bq a;
        synchronized (q) {
            try {
                Bundle bundle;
                Object obj = C0063by.g(notification)[i];
                Bundle a2 = C0063by.a(notification);
                if (a2 != null) {
                    SparseArray sparseParcelableArray = a2.getSparseParcelableArray(c);
                    if (sparseParcelableArray != null) {
                        bundle = (Bundle) sparseParcelableArray.get(i);
                        a = C0063by.a(brVar, cbVar, t.getInt(obj), (CharSequence) u.get(obj), (PendingIntent) v.get(obj), bundle);
                    }
                }
                bundle = null;
                a = C0063by.a(brVar, cbVar, t.getInt(obj), (CharSequence) u.get(obj), (PendingIntent) v.get(obj), bundle);
            } catch (Throwable e) {
                Log.e(a, "Unable to access notification actions", e);
                w = true;
                return null;
            }
        }
        return a;
    }

    private static bq a(Bundle bundle, br brVar, cb cbVar) {
        return brVar.b(bundle.getInt(i), bundle.getCharSequence(j), (PendingIntent) bundle.getParcelable(k), bundle.getBundle(l), cc.a(H.a(bundle, m), cbVar));
    }

    public static bq a(br brVar, cb cbVar, int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        ca[] caVarArr = null;
        if (bundle != null) {
            caVarArr = cc.a(H.a(bundle, d), cbVar);
        }
        return brVar.b(i, charSequence, pendingIntent, bundle, caVarArr);
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static ArrayList<Parcelable> a(bq[] bqVarArr) {
        if (bqVarArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(bqVarArr.length);
        for (bq a : bqVarArr) {
            arrayList.add(C0063by.a(a));
        }
        return arrayList;
    }

    public static void a(C0012aJ c0012aJ, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(c0012aJ.a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void a(C0012aJ c0012aJ, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(c0012aJ.a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void a(C0012aJ c0012aJ, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(c0012aJ.a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    private static boolean a() {
        boolean z = true;
        if (w) {
            return false;
        }
        try {
            if (s == null) {
                r = Class.forName("android.app.Notification$Action");
                t = r.getDeclaredField(i);
                u = r.getDeclaredField(j);
                v = r.getDeclaredField(k);
                s = Notification.class.getDeclaredField("actions");
                s.setAccessible(true);
            }
        } catch (Throwable e) {
            Log.e(a, "Unable to access notification actions", e);
            w = true;
        } catch (Throwable e2) {
            Log.e(a, "Unable to access notification actions", e2);
            w = true;
        }
        if (w) {
            z = false;
        }
        return z;
    }

    public static bq[] a(ArrayList<Parcelable> arrayList, br brVar, cb cbVar) {
        if (arrayList == null) {
            return null;
        }
        bq[] b = brVar.b(arrayList.size());
        for (int i = 0; i < b.length; i++) {
            b[i] = C0063by.a((Bundle) arrayList.get(i), brVar, cbVar);
        }
        return b;
    }

    public static int b(Notification notification) {
        int length;
        synchronized (q) {
            Object[] g = C0063by.g(notification);
            length = g != null ? g.length : 0;
        }
        return length;
    }

    public static boolean c(Notification notification) {
        return C0063by.a(notification).getBoolean(b);
    }

    public static String d(Notification notification) {
        return C0063by.a(notification).getString(e);
    }

    public static boolean e(Notification notification) {
        return C0063by.a(notification).getBoolean(f);
    }

    public static String f(Notification notification) {
        return C0063by.a(notification).getString(g);
    }

    private static Object[] g(Notification notification) {
        synchronized (q) {
            if (C0063by.a()) {
                try {
                    Object[] objArr = (Object[]) s.get(notification);
                    return objArr;
                } catch (Throwable e) {
                    Log.e(a, "Unable to access notification actions", e);
                    w = true;
                    return null;
                }
            }
            return null;
        }
    }
}
