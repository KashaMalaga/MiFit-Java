package cn.com.smartdevices.bracelet.heartrate;

class m implements Runnable {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public void run() {
        this.a.c.u.setVisibility(8);
        this.a.c.x.setVisibility(8);
        this.a.c.q.setVisibility(0);
        if (!this.a.c.n) {
            this.a.c.w.setVisibility(0);
        }
    }
}
