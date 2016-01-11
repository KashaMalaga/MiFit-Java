package android.support.v4.app;

class X implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ U c;

    X(U u, String str, int i) {
        this.c = u;
        this.a = str;
        this.b = i;
    }

    public void run() {
        this.c.a(this.c.u.d, this.a, -1, this.b);
    }
}
