package cn.com.smartdevices.bracelet.relation;

class C0600c implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ DetailActivity b;

    C0600c(DetailActivity detailActivity, int i) {
        this.b = detailActivity;
        this.a = i;
    }

    public void run() {
        this.b.a.d(this.a);
        this.b.a.f(this.a);
        this.b.b.d(this.a);
        this.b.b.f(this.a);
    }
}
