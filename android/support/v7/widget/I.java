package android.support.v7.widget;

class I implements Runnable {
    final /* synthetic */ RecyclerView a;

    I(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void run() {
        if (!this.a.K) {
            return;
        }
        if (this.a.Q) {
            this.a.p();
        } else if (this.a.i.d()) {
            this.a.h();
            this.a.i.b();
            if (!this.a.M) {
                this.a.t();
            }
            this.a.b(true);
        }
    }
}
