package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

public class C0226at {
    private static final aA a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new C0232az();
        } else if (VERSION.SDK_INT >= 11) {
            a = new C0229aw();
        } else {
            a = new aB();
        }
    }

    private C0226at(Context context) {
    }

    public static View a(Context context) {
        return a.a(context);
    }

    public static CharSequence a(View view) {
        return a.a(view);
    }

    public static void a(View view, int i) {
        a.b(view, i);
    }

    public static void a(View view, ComponentName componentName) {
        a.a(view, componentName);
    }

    public static void a(View view, C0227au c0227au) {
        a.b((Object) view, c0227au.a);
    }

    public static void a(View view, C0228av c0228av) {
        a.a((Object) view, c0228av.a);
    }

    public static void a(View view, CharSequence charSequence) {
        a.a(view, charSequence);
    }

    public static void a(View view, CharSequence charSequence, boolean z) {
        a.a(view, charSequence, z);
    }

    public static void a(View view, boolean z) {
        a.a(view, z);
    }

    public static void b(View view, int i) {
        a.c(view, i);
    }

    public static void b(View view, boolean z) {
        a.b(view, z);
    }

    public static boolean b(View view) {
        return a.b(view);
    }

    public static void c(View view, int i) {
        a.a(view, i);
    }

    public static void c(View view, boolean z) {
        a.c(view, z);
    }

    public static boolean c(View view) {
        return a.c(view);
    }

    public static boolean d(View view) {
        return a.d(view);
    }
}
