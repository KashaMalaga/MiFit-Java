package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.a.C0113o;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class aT {
    private static final int D = 5120;
    Notification A;
    Notification B = new Notification();
    public ArrayList<String> C;
    Context a;
    CharSequence b;
    CharSequence c;
    PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    Bitmap g;
    CharSequence h;
    int i;
    int j;
    boolean k = true;
    boolean l;
    bj m;
    CharSequence n;
    int o;
    int p;
    boolean q;
    String r;
    boolean s;
    String t;
    ArrayList<aM> u = new ArrayList();
    boolean v = false;
    String w;
    Bundle x;
    int y = 0;
    int z = 0;

    public aT(Context context) {
        this.a = context;
        this.B.when = System.currentTimeMillis();
        this.B.audioStreamType = -1;
        this.j = 0;
        this.C = new ArrayList();
    }

    private void a(int i, boolean z) {
        if (z) {
            Notification notification = this.B;
            notification.flags |= i;
            return;
        }
        notification = this.B;
        notification.flags &= i ^ -1;
    }

    protected static CharSequence f(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > D) ? charSequence.subSequence(0, D) : charSequence;
    }

    public Bundle a() {
        if (this.x == null) {
            this.x = new Bundle();
        }
        return this.x;
    }

    public aT a(int i) {
        this.B.icon = i;
        return this;
    }

    public aT a(int i, int i2) {
        this.B.icon = i;
        this.B.iconLevel = i2;
        return this;
    }

    public aT a(int i, int i2, int i3) {
        int i4 = 1;
        this.B.ledARGB = i;
        this.B.ledOnMS = i2;
        this.B.ledOffMS = i3;
        int i5 = (this.B.ledOnMS == 0 || this.B.ledOffMS == 0) ? 0 : 1;
        Notification notification = this.B;
        int i6 = this.B.flags & -2;
        if (i5 == 0) {
            i4 = 0;
        }
        notification.flags = i6 | i4;
        return this;
    }

    public aT a(int i, int i2, boolean z) {
        this.o = i;
        this.p = i2;
        this.q = z;
        return this;
    }

    public aT a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.u.add(new aM(i, charSequence, pendingIntent));
        return this;
    }

    public aT a(long j) {
        this.B.when = j;
        return this;
    }

    public aT a(Notification notification) {
        this.A = notification;
        return this;
    }

    public aT a(PendingIntent pendingIntent) {
        this.d = pendingIntent;
        return this;
    }

    public aT a(PendingIntent pendingIntent, boolean z) {
        this.e = pendingIntent;
        a((int) C0113o.h, z);
        return this;
    }

    public aT a(Bitmap bitmap) {
        this.g = bitmap;
        return this;
    }

    public aT a(Uri uri) {
        this.B.sound = uri;
        this.B.audioStreamType = -1;
        return this;
    }

    public aT a(Uri uri, int i) {
        this.B.sound = uri;
        this.B.audioStreamType = i;
        return this;
    }

    public aT a(Bundle bundle) {
        if (bundle != null) {
            if (this.x == null) {
                this.x = new Bundle(bundle);
            } else {
                this.x.putAll(bundle);
            }
        }
        return this;
    }

    public aT a(aM aMVar) {
        this.u.add(aMVar);
        return this;
    }

    public aT a(C0014aY c0014aY) {
        c0014aY.a(this);
        return this;
    }

    public aT a(bj bjVar) {
        if (this.m != bjVar) {
            this.m = bjVar;
            if (this.m != null) {
                this.m.a(this);
            }
        }
        return this;
    }

    public aT a(RemoteViews remoteViews) {
        this.B.contentView = remoteViews;
        return this;
    }

    public aT a(CharSequence charSequence) {
        this.b = f(charSequence);
        return this;
    }

    public aT a(CharSequence charSequence, RemoteViews remoteViews) {
        this.B.tickerText = f(charSequence);
        this.f = remoteViews;
        return this;
    }

    public aT a(String str) {
        this.w = str;
        return this;
    }

    public aT a(boolean z) {
        this.k = z;
        return this;
    }

    public aT a(long[] jArr) {
        this.B.vibrate = jArr;
        return this;
    }

    @Deprecated
    public Notification b() {
        return aK.ai.a(this);
    }

    public aT b(int i) {
        this.i = i;
        return this;
    }

    public aT b(PendingIntent pendingIntent) {
        this.B.deleteIntent = pendingIntent;
        return this;
    }

    public aT b(Bundle bundle) {
        this.x = bundle;
        return this;
    }

    public aT b(CharSequence charSequence) {
        this.c = f(charSequence);
        return this;
    }

    public aT b(String str) {
        this.C.add(str);
        return this;
    }

    public aT b(boolean z) {
        this.l = z;
        return this;
    }

    public Notification c() {
        return aK.ai.a(this);
    }

    public aT c(int i) {
        this.B.defaults = i;
        if ((i & 4) != 0) {
            Notification notification = this.B;
            notification.flags |= 1;
        }
        return this;
    }

    public aT c(CharSequence charSequence) {
        this.n = f(charSequence);
        return this;
    }

    public aT c(String str) {
        this.r = str;
        return this;
    }

    public aT c(boolean z) {
        a(2, z);
        return this;
    }

    public aT d(int i) {
        this.j = i;
        return this;
    }

    public aT d(CharSequence charSequence) {
        this.h = f(charSequence);
        return this;
    }

    public aT d(String str) {
        this.t = str;
        return this;
    }

    public aT d(boolean z) {
        a(8, z);
        return this;
    }

    public aT e(int i) {
        this.y = i;
        return this;
    }

    public aT e(CharSequence charSequence) {
        this.B.tickerText = f(charSequence);
        return this;
    }

    public aT e(boolean z) {
        a(16, z);
        return this;
    }

    public aT f(int i) {
        this.z = i;
        return this;
    }

    public aT f(boolean z) {
        this.v = z;
        return this;
    }

    public aT g(boolean z) {
        this.s = z;
        return this;
    }
}
