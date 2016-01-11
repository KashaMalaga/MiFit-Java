package android.support.v4.f;

import android.os.Build.VERSION;
import java.net.Socket;

public class j {
    private static final p a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new o();
        } else {
            a = new l();
        }
    }

    public static void a() {
        a.a();
    }

    public static void a(int i) {
        a.a(i);
    }

    public static void a(int i, int i2) {
        a.a(i, i2);
    }

    public static void a(Socket socket) {
        a.a(socket);
    }

    public static int b() {
        return a.b();
    }

    public static void b(int i) {
        a.b(i);
    }

    public static void b(Socket socket) {
        a.b(socket);
    }
}
