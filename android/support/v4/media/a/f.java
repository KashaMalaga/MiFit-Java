package android.support.v4.media.a;

import android.media.MediaRouter.RouteGroup;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public static List a(Object obj) {
        RouteGroup routeGroup = (RouteGroup) obj;
        int routeCount = routeGroup.getRouteCount();
        List arrayList = new ArrayList(routeCount);
        for (int i = 0; i < routeCount; i++) {
            arrayList.add(routeGroup.getRouteAt(i));
        }
        return arrayList;
    }
}
