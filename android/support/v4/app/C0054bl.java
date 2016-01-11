package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.RemoteInput;
import android.os.Parcelable;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import java.util.ArrayList;

class C0054bl {
    C0054bl() {
    }

    private static Action a(bq bqVar) {
        Builder addExtras = new Builder(bqVar.a(), bqVar.b(), bqVar.c()).addExtras(bqVar.d());
        ca[] f = bqVar.f();
        if (f != null) {
            for (RemoteInput addRemoteInput : bY.a(f)) {
                addExtras.addRemoteInput(addRemoteInput);
            }
        }
        return addExtras.build();
    }

    private static bq a(Action action, br brVar, cb cbVar) {
        return brVar.b(action.icon, action.title, action.actionIntent, action.getExtras(), bY.a(action.getRemoteInputs(), cbVar));
    }

    public static bq a(Notification notification, int i, br brVar, cb cbVar) {
        return C0054bl.a(notification.actions[i], brVar, cbVar);
    }

    public static ArrayList<Parcelable> a(bq[] bqVarArr) {
        if (bqVarArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(bqVarArr.length);
        for (bq a : bqVarArr) {
            arrayList.add(C0054bl.a(a));
        }
        return arrayList;
    }

    public static void a(Notification.Builder builder, bq bqVar) {
        Builder builder2 = new Builder(bqVar.a(), bqVar.b(), bqVar.c());
        if (bqVar.f() != null) {
            for (RemoteInput addRemoteInput : bY.a(bqVar.f())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (bqVar.d() != null) {
            builder2.addExtras(bqVar.d());
        }
        builder.addAction(builder2.build());
    }

    public static boolean a(Notification notification) {
        return (notification.flags & PersonInfo.INCOMING_CALL_DISABLE_BIT) != 0;
    }

    public static bq[] a(ArrayList<Parcelable> arrayList, br brVar, cb cbVar) {
        if (arrayList == null) {
            return null;
        }
        bq[] b = brVar.b(arrayList.size());
        for (int i = 0; i < b.length; i++) {
            b[i] = C0054bl.a((Action) arrayList.get(i), brVar, cbVar);
        }
        return b;
    }

    public static String b(Notification notification) {
        return notification.getGroup();
    }

    public static boolean c(Notification notification) {
        return (notification.flags & C0113o.j) != 0;
    }

    public static String d(Notification notification) {
        return notification.getSortKey();
    }
}
