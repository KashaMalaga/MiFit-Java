package com.huami.android.widget.share;

import android.view.View;
import android.widget.AdapterView;
import com.huami.android.widget.d;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.a.h;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class r implements d {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = v.P;
        this.a.g.a(h.share_prepare_tips);
        switch (i) {
            case l.a /*1*/:
                i2 = v.O;
                break;
            case a.k /*2*/:
                i2 = v.Q;
                break;
        }
        this.a.c = i2;
        if (this.a.j != null) {
            this.a.j.b();
        }
    }
}
