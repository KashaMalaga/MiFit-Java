package android.support.v7.widget;

class J implements Runnable {
    final /* synthetic */ RecyclerView a;

    J(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void run() {
        if (this.a.l != null) {
            this.a.l.a();
        }
        this.a.an = false;
    }
}
