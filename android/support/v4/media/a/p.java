package android.support.v4.media.a;

import android.media.MediaRouter.RouteInfo;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class p {
    private Method a;
    private int b;

    public p() {
        if (VERSION.SDK_INT != 17) {
            throw new UnsupportedOperationException();
        }
        try {
            this.b = RouteInfo.class.getField("STATUS_CONNECTING").getInt(null);
            this.a = RouteInfo.class.getMethod("getStatusCode", new Class[0]);
        } catch (NoSuchFieldException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        }
    }

    public boolean a(Object obj) {
        RouteInfo routeInfo = (RouteInfo) obj;
        if (this.a != null) {
            try {
                return ((Integer) this.a.invoke(routeInfo, new Object[0])).intValue() == this.b;
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
        return false;
    }
}
