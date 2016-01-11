package android.support.v4.media.a;

import android.content.Context;
import android.media.MediaRouter;
import android.media.MediaRouter.Callback;
import android.media.MediaRouter.RouteCategory;
import android.media.MediaRouter.RouteInfo;
import android.media.MediaRouter.UserRouteInfo;
import java.util.ArrayList;
import java.util.List;

class a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 8388608;
    public static final int d = 8388611;
    private static final String e = "MediaRouterJellybean";

    a() {
    }

    public static Object a(Context context) {
        return context.getSystemService("media_router");
    }

    public static Object a(b bVar) {
        return new c(bVar);
    }

    public static Object a(j jVar) {
        return new k(jVar);
    }

    public static Object a(Object obj, int i) {
        return ((MediaRouter) obj).getSelectedRoute(i);
    }

    public static Object a(Object obj, String str, boolean z) {
        return ((MediaRouter) obj).createRouteCategory(str, z);
    }

    public static List a(Object obj) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        int routeCount = mediaRouter.getRouteCount();
        List arrayList = new ArrayList(routeCount);
        for (int i = 0; i < routeCount; i += a) {
            arrayList.add(mediaRouter.getRouteAt(i));
        }
        return arrayList;
    }

    public static void a(Object obj, int i, Object obj2) {
        ((MediaRouter) obj).selectRoute(i, (RouteInfo) obj2);
    }

    public static void a(Object obj, Object obj2) {
        ((MediaRouter) obj).removeCallback((Callback) obj2);
    }

    public static Object b(Object obj, Object obj2) {
        return ((MediaRouter) obj).createUserRoute((RouteCategory) obj2);
    }

    public static List b(Object obj) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        int categoryCount = mediaRouter.getCategoryCount();
        List arrayList = new ArrayList(categoryCount);
        for (int i = 0; i < categoryCount; i += a) {
            arrayList.add(mediaRouter.getCategoryAt(i));
        }
        return arrayList;
    }

    public static void b(Object obj, int i, Object obj2) {
        ((MediaRouter) obj).addCallback(i, (Callback) obj2);
    }

    public static void c(Object obj, Object obj2) {
        ((MediaRouter) obj).addUserRoute((UserRouteInfo) obj2);
    }

    public static void d(Object obj, Object obj2) {
        ((MediaRouter) obj).removeUserRoute((UserRouteInfo) obj2);
    }
}
