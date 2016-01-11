package android.support.v4.view;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.KeyEvent.DispatcherState;
import android.view.View;

class F {
    F() {
    }

    public static Object a(View view) {
        return view.getKeyDispatcherState();
    }

    public static void a(KeyEvent keyEvent) {
        keyEvent.startTracking();
    }

    public static boolean a(KeyEvent keyEvent, Callback callback, Object obj, Object obj2) {
        return keyEvent.dispatch(callback, (DispatcherState) obj, obj2);
    }

    public static boolean b(KeyEvent keyEvent) {
        return keyEvent.isTracking();
    }
}
