package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

class C0046bh extends C0045bd {
    C0046bh() {
    }

    public Notification a(aT aTVar) {
        C0012aJ c0064bz = new C0064bz(aTVar.a, aTVar.B, aTVar.b, aTVar.c, aTVar.h, aTVar.f, aTVar.i, aTVar.d, aTVar.e, aTVar.g, aTVar.o, aTVar.p, aTVar.q, aTVar.l, aTVar.j, aTVar.n, aTVar.v, aTVar.x, aTVar.r, aTVar.s, aTVar.t);
        aK.b((aI) c0064bz, aTVar.u);
        aK.b(c0064bz, aTVar.m);
        return c0064bz.b();
    }

    public Bundle a(Notification notification) {
        return C0063by.a(notification);
    }

    public aM a(Notification notification, int i) {
        return (aM) C0063by.a(notification, i, aM.d, C0041bR.c);
    }

    public ArrayList<Parcelable> a(aM[] aMVarArr) {
        return C0063by.a((bq[]) aMVarArr);
    }

    public aM[] a(ArrayList<Parcelable> arrayList) {
        return (aM[]) C0063by.a((ArrayList) arrayList, aM.d, C0041bR.c);
    }

    public int b(Notification notification) {
        return C0063by.b(notification);
    }

    public boolean d(Notification notification) {
        return C0063by.c(notification);
    }

    public String e(Notification notification) {
        return C0063by.d(notification);
    }

    public boolean f(Notification notification) {
        return C0063by.e(notification);
    }

    public String g(Notification notification) {
        return C0063by.f(notification);
    }
}
