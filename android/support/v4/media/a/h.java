package android.support.v4.media.a;

import android.media.MediaRouter;
import android.media.MediaRouter.RouteInfo;
import android.os.Build.VERSION;
import android.support.v4.view.C0198v;
import android.util.Log;
import java.lang.reflect.Method;

public final class h {
    private Method a;

    public h() {
        if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 17) {
            throw new UnsupportedOperationException();
        }
        try {
            this.a = MediaRouter.class.getMethod("selectRouteInt", new Class[]{Integer.TYPE, RouteInfo.class});
        } catch (NoSuchMethodException e) {
        }
    }

    public void a(Object obj, int i, Object obj2) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        RouteInfo routeInfo = (RouteInfo) obj2;
        if ((routeInfo.getSupportedTypes() & C0198v.b) == 0) {
            if (this.a != null) {
                try {
                    this.a.invoke(mediaRouter, new Object[]{Integer.valueOf(i), routeInfo});
                    return;
                } catch (Throwable e) {
                    Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", e);
                } catch (Throwable e2) {
                    Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", e2);
                }
            } else {
                Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route because the platform is missing the selectRouteInt() method.  Media routing may not work.");
            }
        }
        mediaRouter.selectRoute(i, routeInfo);
    }
}
