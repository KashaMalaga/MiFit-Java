package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;
import java.util.WeakHashMap;

public class D {
    private static final WeakHashMap<Class<? extends View>, G> a = new WeakHashMap();
    private static C b;

    private static G a(View view) {
        Class cls = view.getClass();
        G g = (G) a.get(cls);
        if (g != null) {
            return g;
        }
        if (view instanceof ViewPager) {
            g = new H();
        } else if (view instanceof HorizontalScrollView) {
            g = new F();
        } else if (view instanceof WebView) {
            g = new I();
        } else if (b == null) {
            return null;
        } else {
            g = b.a(view);
        }
        a.put(cls, g);
        return g;
    }

    public static void a(C c) {
        b = c;
    }

    public static boolean a(View view, int i) {
        G a = a(view);
        return a == null ? false : a.a(view, i);
    }

    public static boolean b(View view, int i) {
        G a = a(view);
        return a == null ? false : a.b(view, i);
    }
}
