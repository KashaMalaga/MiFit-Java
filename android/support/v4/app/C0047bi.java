package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;

class C0047bi extends C0046bh {
    C0047bi() {
    }

    public Notification a(aT aTVar) {
        C0012aJ bBVar = new bB(aTVar.a, aTVar.B, aTVar.b, aTVar.c, aTVar.h, aTVar.f, aTVar.i, aTVar.d, aTVar.e, aTVar.g, aTVar.o, aTVar.p, aTVar.q, aTVar.k, aTVar.l, aTVar.j, aTVar.n, aTVar.v, aTVar.C, aTVar.x, aTVar.r, aTVar.s, aTVar.t);
        aK.b((aI) bBVar, aTVar.u);
        aK.b(bBVar, aTVar.m);
        return bBVar.b();
    }

    public Bundle a(Notification notification) {
        return bA.a(notification);
    }

    public aM a(Notification notification, int i) {
        return (aM) bA.a(notification, i, aM.d, C0041bR.c);
    }

    public int b(Notification notification) {
        return bA.b(notification);
    }

    public boolean d(Notification notification) {
        return bA.c(notification);
    }

    public String e(Notification notification) {
        return bA.d(notification);
    }

    public boolean f(Notification notification) {
        return bA.e(notification);
    }

    public String g(Notification notification) {
        return bA.f(notification);
    }
}
