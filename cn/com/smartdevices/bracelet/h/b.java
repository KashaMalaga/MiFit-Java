package cn.com.smartdevices.bracelet.h;

import com.xiaomi.hm.health.dataprocess.SportDay;

class b implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ a b;

    b(a aVar, boolean z) {
        this.b = aVar;
        this.a = z;
    }

    public void run() {
        SportDay sportDay = new SportDay();
        if (this.a || this.b.i == null || !this.b.i.equals(sportDay)) {
            this.b.i = sportDay;
            this.b.h = this.b.b();
            if (this.b.j != null) {
                this.b.j.a(this.b.h);
            }
        }
    }
}
