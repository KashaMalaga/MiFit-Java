package android.support.v4.media.a;

import android.media.MediaRouter;
import android.media.MediaRouter.Callback;
import android.media.MediaRouter.RouteGroup;
import android.media.MediaRouter.RouteInfo;

class c<T extends b> extends Callback {
    protected final T a;

    public c(T t) {
        this.a = t;
    }

    public void onRouteAdded(MediaRouter mediaRouter, RouteInfo routeInfo) {
        this.a.a(routeInfo);
    }

    public void onRouteChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        this.a.c(routeInfo);
    }

    public void onRouteGrouped(MediaRouter mediaRouter, RouteInfo routeInfo, RouteGroup routeGroup, int i) {
        this.a.a(routeInfo, routeGroup, i);
    }

    public void onRouteRemoved(MediaRouter mediaRouter, RouteInfo routeInfo) {
        this.a.b(routeInfo);
    }

    public void onRouteSelected(MediaRouter mediaRouter, int i, RouteInfo routeInfo) {
        this.a.a(i, (Object) routeInfo);
    }

    public void onRouteUngrouped(MediaRouter mediaRouter, RouteInfo routeInfo, RouteGroup routeGroup) {
        this.a.a((Object) routeInfo, (Object) routeGroup);
    }

    public void onRouteUnselected(MediaRouter mediaRouter, int i, RouteInfo routeInfo) {
        this.a.b(i, routeInfo);
    }

    public void onRouteVolumeChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        this.a.d(routeInfo);
    }
}
