package com.huami.android.widget.share;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.AdapterView;
import com.huami.android.widget.d;
import com.xiaomi.channel.b.v;
import com.xiaomi.hm.health.a.h;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class i implements d {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    @SuppressLint({"NewApi"})
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = v.P;
        this.a.i.a(h.share_prepare_tips);
        switch (i) {
            case l.a /*1*/:
                i2 = v.O;
                break;
            case a.k /*2*/:
                i2 = v.Q;
                break;
        }
        String str = this.a.j.a;
        String str2 = this.a.j.c;
        String str3 = null;
        if (!this.a.k) {
            str3 = this.a.j.d;
        }
        this.a.i.a(i2, str, str2, str3, this.a.j.e);
        this.a.dismiss();
    }
}
