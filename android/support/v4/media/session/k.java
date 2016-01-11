package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;

class k {
    k() {
    }

    public static Object a(Context context, Object obj) {
        return new MediaController(context, (Token) obj);
    }

    public static Object a(l lVar) {
        return new m(lVar);
    }

    public static Object a(Object obj) {
        return ((MediaController) obj).getTransportControls();
    }

    public static void a(Object obj, Object obj2) {
        ((MediaController) obj).unregisterCallback((Callback) obj2);
    }

    public static void a(Object obj, Object obj2, Handler handler) {
        ((MediaController) obj).registerCallback((Callback) obj2, handler);
    }

    public static void a(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    public static boolean a(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    public static Object b(Object obj) {
        return ((MediaController) obj).getPlaybackState();
    }

    public static Object c(Object obj) {
        return ((MediaController) obj).getMetadata();
    }

    public static int d(Object obj) {
        return ((MediaController) obj).getRatingType();
    }

    public static Object e(Object obj) {
        return ((MediaController) obj).getPlaybackInfo();
    }
}
