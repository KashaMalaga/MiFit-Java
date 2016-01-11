package cn.com.smartdevices.bracelet.weibo;

import android.content.Intent;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;

class k implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ j b;

    k(j jVar, int i) {
        this.b = jVar;
        this.a = i;
    }

    public void run() {
        this.b.b.a.a(this.a);
        this.b.b.a.a(true);
        if (BindHealthActivity.a == 1) {
            C0401a.a(this.b.b.a, C0401a.aF);
            this.b.b.a.finish();
        }
        if (BindHealthActivity.a == 3) {
            C0401a.a(this.b.b.a, C0401a.aG);
        }
        if (!this.b.b.a.p && BindHealthActivity.a == 1) {
            Intent intent = new Intent();
            intent.setClass(this.b.b.a, MainUIActivity.class);
            this.b.b.a.startActivity(intent);
        }
    }
}
