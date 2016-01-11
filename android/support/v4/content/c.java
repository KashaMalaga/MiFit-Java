package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import java.io.File;

public class c {
    private static final String a = "ContextCompat";
    private static final String b = "Android";
    private static final String c = "data";
    private static final String d = "obb";
    private static final String e = "files";
    private static final String f = "cache";

    public static final Drawable a(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C0092d.a(context, i) : context.getResources().getDrawable(i);
    }

    private static synchronized File a(File file) {
        synchronized (c.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                Log.w(a, "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }

    private static File a(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            String str = strArr[i];
            File file3 = file2 == null ? new File(str) : str != null ? new File(file2, str) : file2;
            i++;
            file2 = file3;
        }
        return file2;
    }

    public static boolean a(Context context, Intent[] intentArr) {
        return a(context, intentArr, null);
    }

    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0095g.a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0094f.a(context, intentArr);
            return true;
        }
    }

    public static File[] a(Context context) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return C0096h.b(context);
        }
        File a;
        if (i >= 11) {
            a = C0094f.a(context);
        } else {
            a = a(Environment.getExternalStorageDirectory(), b, d, context.getPackageName());
        }
        return new File[]{a};
    }

    public static File[] a(Context context, String str) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return C0096h.a(context, str);
        }
        File a;
        if (i >= 8) {
            a = C0093e.a(context, str);
        } else {
            a = a(Environment.getExternalStorageDirectory(), b, c, context.getPackageName(), e, str);
        }
        return new File[]{a};
    }

    public static File[] b(Context context) {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            return C0096h.a(context);
        }
        File a;
        if (i >= 8) {
            a = C0093e.a(context);
        } else {
            a = a(Environment.getExternalStorageDirectory(), b, c, context.getPackageName(), f);
        }
        return new File[]{a};
    }

    public final File c(Context context) {
        return VERSION.SDK_INT >= 21 ? C0092d.a(context) : a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public final File d(Context context) {
        return VERSION.SDK_INT >= 21 ? C0092d.b(context) : a(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }
}
