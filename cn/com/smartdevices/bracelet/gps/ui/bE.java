package cn.com.smartdevices.bracelet.gps.ui;

import cn.com.smartdevices.bracelet.config.b;
import com.huami.android.widget.share.l;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.b.a.n;

class bE implements Runnable {
    final /* synthetic */ WatermarkShareActivity a;

    bE(WatermarkShareActivity watermarkShareActivity) {
        this.a = watermarkShareActivity;
    }

    public void run() {
        String string = this.a.getString(n.running_share_to_topic);
        l lVar = new l();
        lVar.a = this.a.getString(n.running_share_to_watermark);
        b.h().g.getClass();
        lVar.d = "http://paopaotuan.org/";
        lVar.c = a.f;
        lVar.e = this.a.d;
        lVar.b = string;
        this.a.e.a(lVar);
    }
}
