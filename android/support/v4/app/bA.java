package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.os.Bundle;
import android.util.SparseArray;

class bA {
    bA() {
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static bq a(Notification notification, int i, br brVar, cb cbVar) {
        Action action = notification.actions[i];
        Bundle bundle = null;
        SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(C0059bu.e);
        if (sparseParcelableArray != null) {
            bundle = (Bundle) sparseParcelableArray.get(i);
        }
        return C0063by.a(brVar, cbVar, action.icon, action.title, action.actionIntent, bundle);
    }

    public static int b(Notification notification) {
        return notification.actions != null ? notification.actions.length : 0;
    }

    public static boolean c(Notification notification) {
        return notification.extras.getBoolean(C0059bu.a);
    }

    public static String d(Notification notification) {
        return notification.extras.getString(C0059bu.b);
    }

    public static boolean e(Notification notification) {
        return notification.extras.getBoolean(C0059bu.c);
    }

    public static String f(Notification notification) {
        return notification.extras.getString(C0059bu.d);
    }
}
