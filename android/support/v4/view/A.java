package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

public class A {
    static final E a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new D();
        } else {
            a = new B();
        }
    }

    public static int a(int i) {
        return a.a(i);
    }

    public static Object a(View view) {
        return a.a(view);
    }

    public static boolean a(int i, int i2) {
        return a.a(i, i2);
    }

    public static boolean a(KeyEvent keyEvent) {
        return a.b(keyEvent.getMetaState());
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return a.a(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent, Callback callback, Object obj, Object obj2) {
        return a.a(keyEvent, callback, obj, obj2);
    }

    public static void b(KeyEvent keyEvent) {
        a.a(keyEvent);
    }

    public static boolean b(int i) {
        return a.b(i);
    }

    public static boolean c(KeyEvent keyEvent) {
        return a.b(keyEvent);
    }
}
