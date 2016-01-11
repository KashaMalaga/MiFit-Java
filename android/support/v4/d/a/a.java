package android.support.v4.d.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import java.util.WeakHashMap;

public abstract class a {
    public static final String a = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, a> b = new WeakHashMap();

    a() {
    }

    public static a a(Context context) {
        a aVar;
        synchronized (b) {
            aVar = (a) b.get(context);
            if (aVar == null) {
                aVar = VERSION.SDK_INT >= 17 ? new b(context) : new c(context);
                b.put(context, aVar);
            }
        }
        return aVar;
    }

    public abstract Display a(int i);

    public abstract Display[] a();

    public abstract Display[] a(String str);
}
