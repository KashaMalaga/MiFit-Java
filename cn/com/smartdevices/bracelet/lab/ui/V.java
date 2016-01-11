package cn.com.smartdevices.bracelet.lab.ui;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import cn.com.smartdevices.bracelet.C0596r;
import java.lang.Thread.State;
import java.util.LinkedList;

public class V implements OnCompletionListener, OnErrorListener {
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private aa a = null;
    private final LinkedList<Y> f = new LinkedList();
    private Looper g;
    private MediaPlayer h = null;
    private final String i = "Lab";
    private X j;
    private Z k;
    private final Object l = new Object();
    private WakeLock m;
    private AudioManager n;
    private int o = c;

    public V(String str) {
    }

    private void a(Y y) {
        this.f.add(y);
        if (this.j == null) {
            c();
            this.j = new X(this);
            this.j.start();
        }
    }

    private void b(Y y) {
        try {
            synchronized (this.l) {
                if (!(this.g == null || this.g.getThread().getState() == State.TERMINATED)) {
                    this.g.quit();
                }
                this.k = new Z(this, y);
                synchronized (this.k) {
                    this.k.start();
                    this.k.wait();
                }
            }
        } catch (Exception e) {
            C0596r.a(this.i, e.getMessage());
        }
    }

    private void c() {
        if (this.m != null) {
            this.m.acquire();
        }
    }

    private void d() {
        if (this.m != null) {
            this.m.release();
        }
    }

    public void a() {
        synchronized (this.f) {
            if (this.o != d) {
                Y y = new Y();
                y.g = SystemClock.uptimeMillis();
                y.a = d;
                a(y);
                this.o = d;
            }
        }
    }

    public void a(Context context) {
        if (this.m == null && this.j == null) {
            this.m = ((PowerManager) context.getSystemService("power")).newWakeLock(b, this.i);
            return;
        }
        throw new RuntimeException("assertion failed mWakeLock=" + this.m + " mThread=" + this.j);
    }

    public void a(Context context, Uri uri, boolean z, int i, float f) {
        Y y = new Y();
        y.g = SystemClock.uptimeMillis();
        y.a = b;
        y.b = context;
        y.c = uri;
        y.d = z;
        y.e = i;
        y.f = f;
        synchronized (this.f) {
            a(y);
            this.o = b;
        }
    }

    public void a(aa aaVar) {
        this.a = aaVar;
    }

    public void b() {
        synchronized (this.f) {
            if (this.o != e) {
                Y y = new Y();
                y.g = SystemClock.uptimeMillis();
                y.a = e;
                a(y);
                this.o = e;
            }
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.n != null) {
            this.n.abandonAudioFocus(null);
        }
        synchronized (this.f) {
            if (this.f.size() == 0) {
                synchronized (this.l) {
                    if (this.g != null) {
                        this.g.quit();
                    }
                    this.k = null;
                }
            }
        }
        if (this.a != null) {
            this.a.a();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.a != null) {
            this.a.a(i, i2);
        }
        return false;
    }

    public void stop() {
        synchronized (this.f) {
            if (this.o != c) {
                Y y = new Y();
                y.g = SystemClock.uptimeMillis();
                y.a = c;
                a(y);
                this.o = c;
            }
        }
    }
}
