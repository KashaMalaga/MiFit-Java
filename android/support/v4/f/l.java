package android.support.v4.f;

import java.net.Socket;

class l implements p {
    private ThreadLocal<n> a = new m(this);

    l() {
    }

    public void a() {
        ((n) this.a.get()).a = -1;
    }

    public void a(int i) {
    }

    public void a(int i, int i2) {
    }

    public void a(Socket socket) {
    }

    public int b() {
        return ((n) this.a.get()).a;
    }

    public void b(int i) {
        ((n) this.a.get()).a = i;
    }

    public void b(Socket socket) {
    }
}
