package com.f.a.c;

import android.content.Context;
import android.os.Environment;
import com.g.a.p;
import com.xiaomi.channel.gamesdk.b;
import java.io.File;
import java.io.IOException;

public final class i {
    private static final String a = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String b = "uil-images";

    private i() {
    }

    public static File a(Context context) {
        return a(context, true);
    }

    public static File a(Context context, String str) {
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()) && d(context)) {
            file = new File(Environment.getExternalStorageDirectory(), str);
        }
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    public static File a(Context context, boolean z) {
        File file = null;
        if (z && "mounted".equals(Environment.getExternalStorageState()) && d(context)) {
            file = c(context);
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file != null) {
            return file;
        }
        f.c("Can't define system cache directory! '%s' will be used.", "/data/data/" + context.getPackageName() + "/cache/");
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    public static File b(Context context) {
        File a = a(context);
        File file = new File(a, b);
        return (file.exists() || file.mkdir()) ? file : a;
    }

    private static File c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), p.b), b.b), context.getPackageName()), "cache");
        if (file.exists()) {
            return file;
        }
        if (file.mkdirs()) {
            try {
                new File(file, ".nomedia").createNewFile();
                return file;
            } catch (IOException e) {
                f.b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                return file;
            }
        }
        f.c("Unable to create external cache directory", new Object[0]);
        return null;
    }

    private static boolean d(Context context) {
        return context.checkCallingOrSelfPermission(a) == 0;
    }
}
