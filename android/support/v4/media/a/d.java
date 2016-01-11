package android.support.v4.media.a;

import android.media.MediaRouter;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d {
    private Method a;

    public d() {
        if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 17) {
            throw new UnsupportedOperationException();
        }
        try {
            this.a = MediaRouter.class.getMethod("getSystemAudioRoute", new Class[0]);
        } catch (NoSuchMethodException e) {
        }
    }

    public Object a(Object obj) {
        MediaRouter mediaRouter = (MediaRouter) obj;
        if (this.a != null) {
            try {
                return this.a.invoke(mediaRouter, new Object[0]);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
        }
        return mediaRouter.getRouteAt(0);
    }
}
