package cn.com.smartdevices.bracelet.upgrade;

import cn.com.smartdevices.bracelet.C0596r;
import java.util.concurrent.ConcurrentLinkedQueue;

final class a implements Runnable {
    final /* synthetic */ FwUpgradeManager a;
    private final ConcurrentLinkedQueue<Integer> b = new ConcurrentLinkedQueue();
    private final FwUpgradeManager c;
    private volatile boolean d;
    private h e;

    a(FwUpgradeManager fwUpgradeManager, FwUpgradeManager fwUpgradeManager2) {
        this.a = fwUpgradeManager;
        this.c = fwUpgradeManager2;
    }

    public void a(Integer num, h hVar) {
        if (this.b.contains(num)) {
            C0596r.d("FwUpgradeMananger", "enqueue contains " + num);
            return;
        }
        this.b.offer(num);
        synchronized (this.b) {
            if (!this.d) {
                this.e = hVar;
                this.d = true;
                this.c.getExecutorService().execute(this);
            }
        }
    }

    public void run() {
        while (!this.b.isEmpty()) {
            try {
                Integer num = (Integer) this.b.peek();
                if (num == null) {
                    this.d = false;
                    break;
                } else if (!(this.e == null || num == null)) {
                    this.e.onUpgrade(num.intValue());
                    this.b.poll();
                }
            } catch (Throwable th) {
                if (this.e != null) {
                    this.e.onFinish(this.b);
                }
                this.d = false;
            }
        }
        if (this.e != null) {
            this.e.onFinish(this.b);
        }
        this.d = false;
    }
}
