package com.f.a.b;

import android.content.Context;
import com.f.a.a.a.a.a.h;
import com.f.a.a.a.a.c;
import com.f.a.a.a.b;
import com.f.a.a.b.a.f;
import com.f.a.b.b.d;
import com.f.a.b.c.g;
import com.f.a.c.i;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a {
    public static b a(Context context, com.f.a.a.a.b.a aVar, long j, int i) {
        File b = b(context);
        if (j <= 0 && i <= 0) {
            return new c(i.a(context), b, aVar);
        }
        b hVar = new h(i.b(context), aVar, j, i);
        hVar.a(b);
        return hVar;
    }

    public static com.f.a.a.b.c a(int i) {
        if (i == 0) {
            i = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        return new f(i);
    }

    public static d a(boolean z) {
        return new com.f.a.b.b.a(z);
    }

    public static com.f.a.b.d.c a(Context context) {
        return new com.f.a.b.d.a(context);
    }

    public static Executor a() {
        return Executors.newCachedThreadPool(a(5, "uil-pool-d-"));
    }

    public static Executor a(int i, int i2, com.f.a.b.a.h hVar) {
        return new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, (hVar == com.f.a.b.a.h.LIFO ? 1 : null) != null ? new com.f.a.b.a.a.c() : new LinkedBlockingQueue(), a(i2, "uil-pool-"));
    }

    private static ThreadFactory a(int i, String str) {
        return new b(i, str);
    }

    public static com.f.a.a.a.b.a b() {
        return new com.f.a.a.a.b.b();
    }

    private static File b(Context context) {
        File a = i.a(context, false);
        File file = new File(a, "uil-images");
        return (file.exists() || file.mkdir()) ? file : a;
    }

    public static com.f.a.b.c.a c() {
        return new g();
    }
}
