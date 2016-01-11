package android.support.v4.media.a;

import android.media.MediaRouter.RouteInfo;
import android.media.MediaRouter.VolumeCallback;

class k<T extends j> extends VolumeCallback {
    protected final T a;

    public k(T t) {
        this.a = t;
    }

    public void onVolumeSetRequest(RouteInfo routeInfo, int i) {
        this.a.a(routeInfo, i);
    }

    public void onVolumeUpdateRequest(RouteInfo routeInfo, int i) {
        this.a.b(routeInfo, i);
    }
}
