package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.view.View;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

class l implements OnGetPlaybackPositionListener, OnPlaybackPositionUpdateListener {
    final Context a;
    final AudioManager b;
    final View c;
    final k d;
    final String e;
    final IntentFilter f;
    final Intent g;
    final OnWindowAttachListener h = new m(this);
    final OnWindowFocusChangeListener i = new n(this);
    final BroadcastReceiver j = new o(this);
    OnAudioFocusChangeListener k = new p(this);
    PendingIntent l;
    RemoteControlClient m;
    boolean n;
    int o = 0;
    boolean p;

    public l(Context context, AudioManager audioManager, View view, k kVar) {
        this.a = context;
        this.b = audioManager;
        this.c = view;
        this.d = kVar;
        this.e = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.g = new Intent(this.e);
        this.g.setPackage(context.getPackageName());
        this.f = new IntentFilter();
        this.f.addAction(this.e);
        this.c.getViewTreeObserver().addOnWindowAttachListener(this.h);
        this.c.getViewTreeObserver().addOnWindowFocusChangeListener(this.i);
    }

    public Object a() {
        return this.m;
    }

    public void a(boolean z, long j, int i) {
        if (this.m != null) {
            this.m.setPlaybackState(z ? 3 : 1, j, z ? 1.0f : 0.0f);
            this.m.setTransportControlFlags(i);
        }
    }

    public void b() {
        k();
        this.c.getViewTreeObserver().removeOnWindowAttachListener(this.h);
        this.c.getViewTreeObserver().removeOnWindowFocusChangeListener(this.i);
    }

    void c() {
        this.a.registerReceiver(this.j, this.f);
        this.l = PendingIntent.getBroadcast(this.a, 0, this.g, 268435456);
        this.m = new RemoteControlClient(this.l);
        this.m.setOnGetPlaybackPositionListener(this);
        this.m.setPlaybackPositionUpdateListener(this);
    }

    void d() {
        if (!this.n) {
            this.n = true;
            this.b.registerMediaButtonEventReceiver(this.l);
            this.b.registerRemoteControlClient(this.m);
            if (this.o == 3) {
                e();
            }
        }
    }

    void e() {
        if (!this.p) {
            this.p = true;
            this.b.requestAudioFocus(this.k, 3, 1);
        }
    }

    public void f() {
        if (this.o != 3) {
            this.o = 3;
            this.m.setPlaybackState(3);
        }
        if (this.n) {
            e();
        }
    }

    public void g() {
        if (this.o == 3) {
            this.o = 2;
            this.m.setPlaybackState(2);
        }
        i();
    }

    public void h() {
        if (this.o != 1) {
            this.o = 1;
            this.m.setPlaybackState(1);
        }
        i();
    }

    void i() {
        if (this.p) {
            this.p = false;
            this.b.abandonAudioFocus(this.k);
        }
    }

    void j() {
        i();
        if (this.n) {
            this.n = false;
            this.b.unregisterRemoteControlClient(this.m);
            this.b.unregisterMediaButtonEventReceiver(this.l);
        }
    }

    void k() {
        j();
        if (this.l != null) {
            this.a.unregisterReceiver(this.j);
            this.l.cancel();
            this.l = null;
            this.m = null;
        }
    }

    public long onGetPlaybackPosition() {
        return this.d.a();
    }

    public void onPlaybackPositionUpdate(long j) {
        this.d.a(j);
    }
}
