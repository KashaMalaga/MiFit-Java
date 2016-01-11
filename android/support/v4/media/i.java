package android.support.v4.media;

import android.view.KeyEvent;

class i implements k {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public long a() {
        return this.a.b.e();
    }

    public void a(int i) {
        this.a.b.a(i);
    }

    public void a(long j) {
        this.a.b.a(j);
    }

    public void a(KeyEvent keyEvent) {
        keyEvent.dispatch(this.a.t);
    }
}
