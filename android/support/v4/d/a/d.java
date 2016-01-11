package android.support.v4.d.a;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.sina.weibo.sdk.constant.WBConstants;

final class d {
    d() {
    }

    public static Display a(Object obj, int i) {
        return ((DisplayManager) obj).getDisplay(i);
    }

    public static Object a(Context context) {
        return context.getSystemService(WBConstants.AUTH_PARAMS_DISPLAY);
    }

    public static Display[] a(Object obj) {
        return ((DisplayManager) obj).getDisplays();
    }

    public static Display[] a(Object obj, String str) {
        return ((DisplayManager) obj).getDisplays(str);
    }
}
