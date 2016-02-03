package cn.com.smartdevices.bracelet.ui;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.aj;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.BtDevice;
import cn.com.smartdevices.bracelet.view.O;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.model.e;
import java.util.Collections;
import java.util.Iterator;

class C0768dq extends Handler {
    final /* synthetic */ SearchSingleBraceletActivity a;

    C0768dq(SearchSingleBraceletActivity searchSingleBraceletActivity) {
        this.a = searchSingleBraceletActivity;
    }

    @SuppressLint({"NewApi"})
    public void handleMessage(Message message) {
        int i = message.what;
        C0596r.e("WPJ", "search bracelet message:" + String.format("0x%x", new Object[]{Integer.valueOf(i)}));
        switch (i) {
            case aj.I /*4097*/:
                if (this.a.b) {
                    b.a(this.a.A, (int) R.string.connect_bracelet_now, 1).show();
                    return;
                }
                return;
            case 4098:
                C0596r.e("SearchSingleBraceletActivity", "STOP_SCAN_BRACELET");
                removeMessages(aj.K);
                removeMessages(4098);
                this.a.p();
                if (this.a.x.size() < 1) {
                    if (this.a.b) {
                        b.a(this.a.A, (int) R.string.device_not_found, 0).show();
                    }
                    this.a.t();
                    C0401a.d(this.a.A, C0401a.dE);
                    C0401a.a(this.a.A, C0401a.dF, 0);
                    return;
                } else if (this.a.G != null && !this.a.b) {
                    if (this.a.b) {
                        b.a(this.a.A, (int) R.string.search_bracelet_ok, 1).show();
                    }
                    C0596r.e("SearchSingleBraceletActivity", "Connect device,Found:" + this.a.G.device.getAddress() + ", signal= " + this.a.G.signal);
                    C0401a.d(this.a.A, C0401a.dE);
                    C0401a.a(this.a.A, C0401a.dF, this.a.x.size());
                    this.a.a(this.a.G.device);
                    return;
                } else {
                    return;
                }
            case aj.K /*4099*/:
                C0596r.e("SearchSingleBraceletActivity", "MSG_FIRST_TIMEOUT_SCAN_BRACELET");
                removeMessages(4098);
                sendEmptyMessageDelayed(4098, 1000);
                return;
            case 4100:
                this.a.u = -1;
                return;
            case 4101:
                O.a();
                C0596r.e("SearchSingleBraceletActivity", " connection failed");
                this.a.s();
                C0401a.a(this.a.A, C0401a.dH, C0401a.dB);
                this.a.ad = false;
                return;
            case 4102:
                this.a.e();
                this.a.ad = false;
                return;
            case 4103:
                this.a.c();
                return;
            case 4104:
                this.a.d();
                return;
            case 4105:
                synchronized (this.a.y) {
                    Iterator it = this.a.y.iterator();
                    while (it.hasNext()) {
                        int i2;
                        BtDevice btDevice = (BtDevice) it.next();
                        Iterator it2 = this.a.x.iterator();
                        while (it2.hasNext()) {
                            if (((BtDevice) it2.next()).getAddress().equals(btDevice.getAddress())) {
                                i2 = 1;
                                if (i2 == 0) {
                                    this.a.x.add(btDevice);
                                }
                            }
                        }
                        boolean z = false;
                        if (i2 == 0) {
                            this.a.x.add(btDevice);
                        }
                    }
                    Collections.sort(this.a.x, new C0673ac());
                    this.a.z.notifyDataSetChanged();
                    this.a.y.clear();
                }
                return;
            case 4106:
                e eVar = (e) message.obj;
                this.a.a(eVar.a, eVar.b);
                return;
            default:
                return;
        }
    }
}
