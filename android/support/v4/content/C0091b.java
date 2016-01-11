package android.support.v4.content;

import java.util.concurrent.CountDownLatch;

final class C0091b extends z<Void, Void, D> implements Runnable {
    D a;
    boolean b;
    final /* synthetic */ C0090a c;
    private CountDownLatch e = new CountDownLatch(1);

    C0091b(C0090a c0090a) {
        this.c = c0090a;
    }

    protected D a(Void... voidArr) {
        this.a = this.c.e();
        return this.a;
    }

    protected void a() {
        try {
            this.c.a(this, this.a);
        } finally {
            this.e.countDown();
        }
    }

    protected void a(D d) {
        try {
            this.c.b(this, d);
        } finally {
            this.e.countDown();
        }
    }

    public void run() {
        this.b = false;
        this.c.c();
    }
}
