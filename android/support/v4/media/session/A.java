package android.support.v4.media.session;

import android.os.SystemClock;

public final class A {
    private int a;
    private long b;
    private long c;
    private float d;
    private long e;
    private CharSequence f;
    private long g;

    public A(PlaybackStateCompat playbackStateCompat) {
        this.a = playbackStateCompat.z;
        this.b = playbackStateCompat.A;
        this.d = playbackStateCompat.C;
        this.g = playbackStateCompat.F;
        this.c = playbackStateCompat.B;
        this.e = playbackStateCompat.D;
        this.f = playbackStateCompat.E;
    }

    public PlaybackStateCompat a() {
        return new PlaybackStateCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public void a(int i, long j, float f) {
        this.a = i;
        this.b = j;
        this.d = f;
        this.g = SystemClock.elapsedRealtime();
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(CharSequence charSequence) {
        this.f = charSequence;
    }

    public void b(long j) {
        this.e = j;
    }
}
