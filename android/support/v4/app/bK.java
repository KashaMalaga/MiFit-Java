package android.support.v4.app;

import android.app.Notification;

class bK implements bO {
    final String a;
    final int b;
    final String c;
    final Notification d;

    public bK(String str, int i, String str2, Notification notification) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = notification;
    }

    public void a(C0031as c0031as) {
        c0031as.a(this.a, this.b, this.c, this.d);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
        stringBuilder.append("packageName:").append(this.a);
        stringBuilder.append(", id:").append(this.b);
        stringBuilder.append(", tag:").append(this.c);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
