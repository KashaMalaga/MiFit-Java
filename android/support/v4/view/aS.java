package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

class aS {
    public static final String a = "ViewCompat";
    private static Method b;

    aS() {
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        if (b == null) {
            try {
                b = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e(a, "Unable to find childrenDrawingOrderEnabled", e);
            }
            b.setAccessible(true);
        }
        try {
            b.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e2) {
            Log.e(a, "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e(a, "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e(a, "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }

    public static boolean a(View view) {
        return view.isOpaque();
    }
}
