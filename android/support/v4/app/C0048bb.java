package android.support.v4.app;

import android.app.Notification;
import android.os.Parcelable;
import java.util.ArrayList;

class C0048bb extends C0047bi {
    C0048bb() {
    }

    public Notification a(aT aTVar) {
        C0012aJ c0055bm = new C0055bm(aTVar.a, aTVar.B, aTVar.b, aTVar.c, aTVar.h, aTVar.f, aTVar.i, aTVar.d, aTVar.e, aTVar.g, aTVar.o, aTVar.p, aTVar.q, aTVar.k, aTVar.l, aTVar.j, aTVar.n, aTVar.v, aTVar.C, aTVar.x, aTVar.r, aTVar.s, aTVar.t);
        aK.b((aI) c0055bm, aTVar.u);
        aK.b(c0055bm, aTVar.m);
        return c0055bm.b();
    }

    public aM a(Notification notification, int i) {
        return (aM) C0054bl.a(notification, i, aM.d, C0041bR.c);
    }

    public ArrayList<Parcelable> a(aM[] aMVarArr) {
        return C0054bl.a((bq[]) aMVarArr);
    }

    public aM[] a(ArrayList<Parcelable> arrayList) {
        return (aM[]) C0054bl.a((ArrayList) arrayList, aM.d, C0041bR.c);
    }

    public boolean d(Notification notification) {
        return C0054bl.a(notification);
    }

    public String e(Notification notification) {
        return C0054bl.b(notification);
    }

    public boolean f(Notification notification) {
        return C0054bl.c(notification);
    }

    public String g(Notification notification) {
        return C0054bl.d(notification);
    }
}
