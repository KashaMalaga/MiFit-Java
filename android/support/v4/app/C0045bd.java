package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.a.C0113o;
import java.util.ArrayList;

class C0045bd implements C0044ba {
    C0045bd() {
    }

    public Notification a(aT aTVar) {
        Notification notification = aTVar.B;
        notification.setLatestEventInfo(aTVar.a, aTVar.b, aTVar.c, aTVar.d);
        if (aTVar.j > 0) {
            notification.flags |= C0113o.h;
        }
        return notification;
    }

    public Bundle a(Notification notification) {
        return null;
    }

    public Bundle a(bs bsVar) {
        return null;
    }

    public aM a(Notification notification, int i) {
        return null;
    }

    public bs a(Bundle bundle, bt btVar, cb cbVar) {
        return null;
    }

    public ArrayList<Parcelable> a(aM[] aMVarArr) {
        return null;
    }

    public aM[] a(ArrayList<Parcelable> arrayList) {
        return null;
    }

    public int b(Notification notification) {
        return 0;
    }

    public String c(Notification notification) {
        return null;
    }

    public boolean d(Notification notification) {
        return false;
    }

    public String e(Notification notification) {
        return null;
    }

    public boolean f(Notification notification) {
        return false;
    }

    public String g(Notification notification) {
        return null;
    }
}
