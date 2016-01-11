package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import com.xiaomi.account.openauth.h;
import java.util.ArrayList;
import java.util.List;

class aB extends Handler {
    final /* synthetic */ MapTestActivity a;

    aB(MapTestActivity mapTestActivity) {
        this.a = mapTestActivity;
    }

    public void a() {
        Message obtain = Message.obtain();
        obtain.what = h.E;
        sendMessageDelayed(obtain, 300);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case h.E /*1000*/:
                List arrayList = new ArrayList(1);
                if (this.a.o == this.a.t.size() - 1) {
                    this.a.p = false;
                }
                if (this.a.o == 0) {
                    this.a.p = true;
                }
                c cVar;
                if (this.a.p) {
                    this.a.o = this.a.o + MapTestActivity.d;
                    cVar = (c) this.a.t.get(this.a.o);
                    cVar.p += 0.001d;
                    cVar.q += 0.001d;
                    arrayList.add(cVar);
                } else {
                    this.a.o = this.a.o - 1;
                    cVar = (c) this.a.t.get(this.a.o);
                    cVar.p -= 0.002d;
                    cVar.q -= 0.002d;
                    arrayList.add(cVar);
                }
                this.a.l.c(arrayList, new g());
                a();
                return;
            default:
                return;
        }
    }
}
