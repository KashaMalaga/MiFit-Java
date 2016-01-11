package android.support.v4.media.a;

import android.media.MediaRouter;
import android.media.MediaRouter.RouteInfo;

class o<T extends n> extends c<T> {
    public o(T t) {
        super(t);
    }

    public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        ((n) this.a).e(routeInfo);
    }
}
