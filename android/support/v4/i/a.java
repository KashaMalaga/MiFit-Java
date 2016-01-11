package android.support.v4.i;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.File;

public abstract class a {
    static final String a = "DocumentFile";
    private final a b;

    a(a aVar) {
        this.b = aVar;
    }

    public static a a(Context context, Uri uri) {
        return VERSION.SDK_INT >= 19 ? new e(null, context, uri) : null;
    }

    public static a a(File file) {
        return new d(null, file);
    }

    public static a b(Context context, Uri uri) {
        return VERSION.SDK_INT >= 21 ? new f(null, context, c.a(uri)) : null;
    }

    public static boolean c(Context context, Uri uri) {
        return VERSION.SDK_INT >= 19 ? b.a(context, uri) : false;
    }

    public abstract Uri a();

    public abstract a a(String str);

    public abstract a a(String str, String str2);

    public a b(String str) {
        for (a aVar : m()) {
            if (str.equals(aVar.b())) {
                return aVar;
            }
        }
        return null;
    }

    public abstract String b();

    public abstract String c();

    public abstract boolean c(String str);

    public a d() {
        return this.b;
    }

    public abstract boolean e();

    public abstract boolean f();

    public abstract long g();

    public abstract long h();

    public abstract boolean i();

    public abstract boolean j();

    public abstract boolean k();

    public abstract boolean l();

    public abstract a[] m();
}
