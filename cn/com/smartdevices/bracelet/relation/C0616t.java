package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.push.j;

class C0616t implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ FriendActivity b;

    C0616t(FriendActivity friendActivity, j jVar) {
        this.b = friendActivity;
        this.a = jVar;
    }

    public void run() {
        this.b.h.a(this.a.l);
        if (this.b.h.getCount() == 0) {
            this.b.i.setVisibility(0);
            this.b.g.setVisibility(8);
            return;
        }
        this.b.i.setVisibility(8);
        this.b.g.setVisibility(0);
    }
}
