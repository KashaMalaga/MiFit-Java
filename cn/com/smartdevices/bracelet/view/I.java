package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class I implements G {
    private I() {
    }

    public boolean a(View view, int i) {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("computeHorizontalScrollOffset", new Class[0]);
            Method declaredMethod2 = WebView.class.getDeclaredMethod("computeHorizontalScrollRange", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            return (i > 0 && view.getScrollX() > 0) || (i < 0 && ((Integer) declaredMethod.invoke(view, new Object[0])).intValue() < ((Integer) declaredMethod2.invoke(view, new Object[0])).intValue() - view.getWidth());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public boolean b(View view, int i) {
        return false;
    }
}
