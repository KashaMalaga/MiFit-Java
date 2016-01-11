package android.support.v4.app;

import android.app.Notification;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

public class aK {
    public static final String A = "android.bigText";
    public static final String B = "android.icon";
    public static final String C = "android.largeIcon";
    public static final String D = "android.largeIcon.big";
    public static final String E = "android.progress";
    public static final String F = "android.progressMax";
    public static final String G = "android.progressIndeterminate";
    public static final String H = "android.showChronometer";
    public static final String I = "android.showWhen";
    public static final String J = "android.picture";
    public static final String K = "android.textLines";
    public static final String L = "android.template";
    public static final String M = "android.people";
    public static final String N = "android.backgroundImageUri";
    public static final String O = "android.mediaSession";
    public static final String P = "android.compactActions";
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 0;
    public static final int T = -1;
    public static final String U = "call";
    public static final String V = "msg";
    public static final String W = "email";
    public static final String X = "event";
    public static final String Y = "promo";
    public static final String Z = "alarm";
    public static final int a = -1;
    public static final String aa = "progress";
    public static final String ab = "social";
    public static final String ac = "err";
    public static final String ad = "transport";
    public static final String ae = "sys";
    public static final String af = "service";
    public static final String ag = "recommendation";
    public static final String ah = "status";
    private static final C0044ba ai;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = -1;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 4;
    public static final int i = 8;
    public static final int j = 16;
    public static final int k = 32;
    public static final int l = 64;
    public static final int m = 128;
    public static final int n = 256;
    public static final int o = 512;
    public static final int p = 0;
    public static final int q = -1;
    public static final int r = -2;
    public static final int s = 1;
    public static final int t = 2;
    public static final String u = "android.title";
    public static final String v = "android.title.big";
    public static final String w = "android.text";
    public static final String x = "android.subText";
    public static final String y = "android.infoText";
    public static final String z = "android.summaryText";

    static {
        if (VERSION.SDK_INT >= 21) {
            ai = new C0049bc();
        } else if (VERSION.SDK_INT >= 20) {
            ai = new C0048bb();
        } else if (VERSION.SDK_INT >= 19) {
            ai = new C0047bi();
        } else if (VERSION.SDK_INT >= j) {
            ai = new C0046bh();
        } else if (VERSION.SDK_INT >= 14) {
            ai = new C0052bg();
        } else if (VERSION.SDK_INT >= 11) {
            ai = new C0051bf();
        } else if (VERSION.SDK_INT >= 9) {
            ai = new C0050be();
        } else {
            ai = new C0045bd();
        }
    }

    public static Bundle a(Notification notification) {
        return ai.a(notification);
    }

    public static aM a(Notification notification, int i) {
        return ai.a(notification, i);
    }

    public static int b(Notification notification) {
        return ai.b(notification);
    }

    private static void b(aI aIVar, ArrayList<aM> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aIVar.a((aM) it.next());
        }
    }

    private static void b(C0012aJ c0012aJ, bj bjVar) {
        if (bjVar == null) {
            return;
        }
        if (bjVar instanceof aS) {
            aS aSVar = (aS) bjVar;
            C0063by.a(c0012aJ, aSVar.e, aSVar.g, aSVar.f, aSVar.a);
        } else if (bjVar instanceof aZ) {
            aZ aZVar = (aZ) bjVar;
            C0063by.a(c0012aJ, aZVar.e, aZVar.g, aZVar.f, aZVar.a);
        } else if (bjVar instanceof C0013aR) {
            C0013aR c0013aR = (C0013aR) bjVar;
            C0063by.a(c0012aJ, c0013aR.e, c0013aR.g, c0013aR.f, c0013aR.a, c0013aR.b, c0013aR.c);
        }
    }

    private static Notification[] b(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Parcelable[] parcelableArr = new Notification[parcelableArray.length];
        for (int i = p; i < parcelableArray.length; i += s) {
            parcelableArr[i] = (Notification) parcelableArray[i];
        }
        bundle.putParcelableArray(str, parcelableArr);
        return parcelableArr;
    }

    public static String c(Notification notification) {
        return ai.c(notification);
    }

    public static boolean d(Notification notification) {
        return ai.d(notification);
    }

    public static String e(Notification notification) {
        return ai.e(notification);
    }

    public static boolean f(Notification notification) {
        return ai.f(notification);
    }

    public static String g(Notification notification) {
        return ai.g(notification);
    }
}
