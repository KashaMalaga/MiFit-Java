package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public class C0099a {
    public static final int a = 128;
    public static final int b = 256;
    public static final int c = 512;
    public static final int d = 1024;
    public static final int e = 2048;
    public static final int f = 4096;
    public static final int g = 8192;
    public static final int h = 16384;
    public static final int i = 32768;
    public static final int j = 65536;
    public static final int k = 131072;
    public static final int l = 262144;
    public static final int m = 524288;
    public static final int n = 1048576;
    public static final int o = 2097152;
    public static final int p = -1;
    private static final C0100d q;

    static {
        if (VERSION.SDK_INT >= 14) {
            q = new C0102b();
        } else {
            q = new C0101c();
        }
    }

    private C0099a() {
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        return q.a(accessibilityEvent);
    }

    public static Y a(AccessibilityEvent accessibilityEvent, int i) {
        return new Y(q.a(accessibilityEvent, i));
    }

    public static void a(AccessibilityEvent accessibilityEvent, Y y) {
        q.a(accessibilityEvent, y.a());
    }

    public static Y b(AccessibilityEvent accessibilityEvent) {
        return new Y(accessibilityEvent);
    }
}
